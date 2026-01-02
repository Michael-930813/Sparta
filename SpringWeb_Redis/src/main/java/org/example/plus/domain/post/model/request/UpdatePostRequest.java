package org.example.plus.domain.post.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@AllArgsConstructor
public class UpdatePostRequest {
// - Properties
    private String content;
}
