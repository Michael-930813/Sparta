package org.example.plus.domain.comment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.plus.common.entity.Comment;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private long commentId;
    private String content;
    private long postId;

    public static CommentDto from(Comment comment, long postId) {
        return new CommentDto(comment.getId(), comment.getContent(), postId);
    }
}
