package org.example.plus.domain.post.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.plus.common.entity.Post;
import org.example.plus.common.entity.User;
import org.example.plus.domain.post.model.dto.PostDto;
import org.example.plus.domain.post.model.dto.PostSummaryDto;
import org.example.plus.domain.post.repository.PostRepository;
import org.example.plus.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostDto creatPost(String username, String content) {

        User user = userRepository.findUserByUsername(username).orElseThrow(
            ()-> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        Post post = postRepository.save(new Post(content, user.getId()));

        return PostDto.from(post, user.getUsername());

    }


    // 지연 로딩이구나
    // 실질적으로 사용할 때 불러오는 것이구나!

    // 즉시 로딩으로 한번 테스트를 진행해보겠습니다!
    // 유저를 조회 하자 마자 조회를 할때 연관된 모든 것들을 싸그리 싹싹 긁거서 가져올 것이다.
    public List<PostSummaryDto> getPostListByUsername(String username) {
        // - Find User
        User user = userRepository.findUserByUsername(username).orElseThrow(
            () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        // - Find PostList
        List<PostSummaryDto> result = postRepository.finPostSummary(username);

        // - Return
        return result;
    }

    public List<PostSummaryDto> getPostSummaryListByUsername(String username) {

        List<PostSummaryDto> result = postRepository.finPostSummary(username);
        return result;
    }
}


