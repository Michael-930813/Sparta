package sparta.domain.post.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sparta.common.entity.Post;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
// - Properties
    private Long id;
    private String content;
    private String username;

// - Methods
    public static PostDto from(Post post) {
        return new PostDto(post.getId(), post.getContent(), post.getUser().getUsername());
    }
}
