package org.example.plus.domain.post.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@NoArgsConstructor
public class UpdatePostRequest {
// - Properties
    private String content;
}
