package org.example.plus.domain.post.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.plus.common.entity.Post;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private long id;
    private String content;
    private String username;

    public static PostDto from(Post post, String username) {
        return new PostDto(post.getId(), post.getContent(), username);
    }
}
