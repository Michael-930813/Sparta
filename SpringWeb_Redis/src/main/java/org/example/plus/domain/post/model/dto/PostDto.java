package org.example.plus.domain.post.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.plus.common.entity.Post;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private long id;
    private String content;
    private long userId;
    private LocalDate check;

    public static PostDto from(Post post) {
        return new PostDto(post.getId(), post.getContent(), post.getUserId(), LocalDate.now());
    }

}
