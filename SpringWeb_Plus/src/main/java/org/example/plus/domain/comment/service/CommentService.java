package org.example.plus.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.example.plus.common.entity.Comment;
import org.example.plus.common.entity.Post;
import org.example.plus.domain.comment.model.dto.CommentDto;
import org.example.plus.domain.comment.repository.CommentRepository;
import org.example.plus.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    public CommentDto createComment(long postId, String content) {

        Post post = postRepository.findById(postId).orElseThrow(
            () -> new IllegalArgumentException("등록된 Post가 없습니다.")
        );

        Comment comment = new Comment(content, post.getId());

        commentRepository.save(comment);

        return CommentDto.from(comment, post.getId());

    }
}
