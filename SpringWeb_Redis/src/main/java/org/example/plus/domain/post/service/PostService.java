package org.example.plus.domain.post.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.plus.common.entity.Post;
import org.example.plus.common.entity.User;
import org.example.plus.domain.post.model.dto.PostDto;
import org.example.plus.domain.post.model.dto.PostSummaryDto;
import org.example.plus.domain.post.model.request.UpdatePostRequest;
import org.example.plus.domain.post.repository.PostRepository;
import org.example.plus.domain.user.repository.UserRepository;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostCacheService postCacheService;

    public PostDto creatPost(String username, String content) {

        User user = userRepository.findUserByUsername(username).orElseThrow(
            ()-> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        Post post = postRepository.save(new Post(content, user.getId()));

        return PostDto.from(post);

    }

    // - Redis Methods
    public PostDto getPostById(Long postId) {
        // - If exist cache data -> return cache data
        PostDto cached = postCacheService.getPostCache(postId);

        if (cached != null) {
            log.info("{} Redis Data Cache Hit", postId);
            postCacheService.increaseViewCount(postId);
            return cached;
        }

        // - Or Not, Join DB & Save Cache Data
        log.info("{} Redis Data Cache Miss", postId);

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post가 없습니다."));
        // - Increase ViewCount
        postCacheService.increaseViewCount(postId);

        PostDto dto = PostDto.from(post);
        postCacheService.savePostCache(postId, dto);

        return dto;
    }
    public PostDto updatePostById(Long postId, UpdatePostRequest request) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post가 없습니다."));

        post.update(request);

        postRepository.save(post);
        postCacheService.deletePostCache(postId);

        return PostDto.from(post);
    }

    public List<PostDto> getTopPostList(Integer limit) {
        List<Long> topPostIdList = postCacheService.getTopPostList(limit);
        List<PostDto> result = new ArrayList<>();

        if (topPostIdList == null || topPostIdList.isEmpty()) {
            return Collections.emptyList();
        }

        for (Long postId : topPostIdList) {
            // - Check Cache Data
            PostDto dto = postCacheService.getPostCache(postId);

            // - If No Cache Data, Join DB
            if (dto == null) {
                dto = PostDto.from(postRepository.findById(postId)
                        .orElseThrow(() -> new IllegalArgumentException("Post가 없습니다")));
            }

            result.add(dto);
        }

        return result;
    }
}


