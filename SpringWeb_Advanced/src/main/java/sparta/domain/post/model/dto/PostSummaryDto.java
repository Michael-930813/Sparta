package sparta.domain.post.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
public class PostSummaryDto {
// - Properties
    private String content;
    private Integer commentCount;
 }
