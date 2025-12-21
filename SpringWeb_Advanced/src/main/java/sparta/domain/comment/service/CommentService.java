package sparta.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sparta.common.entity.Comment;
import sparta.common.entity.Post;
import sparta.domain.comment.model.dto.CommentDto;
import sparta.domain.comment.repository.CommentRepository;
import sparta.domain.post.repository.PostRepository;

@Service
@RequiredArgsConstructor
public class CommentService {
// - Properties
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

// - Methods
    public CommentDto createComment(Long postId, String content) {
        Post post = postRepository.findById(postId).orElseThrow(
            () -> new IllegalArgumentException("등록된 게시물이 없습니다.")
        );

        Comment comment = new Comment(content, post);

        commentRepository.save(comment);

        return CommentDto.from(comment);
    }
}
