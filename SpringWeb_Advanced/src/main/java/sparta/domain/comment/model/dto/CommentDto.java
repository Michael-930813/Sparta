package sparta.domain.comment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sparta.common.entity.Comment;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
// - Properties
    private Long id;
    private String content;
    private long postId;

// - Methods
    public static CommentDto from(Comment comment) {
        return new CommentDto(comment.getId(), comment.getContent(), comment.getPost().getId());
    }
}
