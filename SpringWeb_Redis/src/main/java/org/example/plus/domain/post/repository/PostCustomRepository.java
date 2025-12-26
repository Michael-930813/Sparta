package org.example.plus.domain.post.repository;

import java.util.List;
import org.example.plus.domain.post.model.dto.PostSummaryDto;

public interface PostCustomRepository {

    List<PostSummaryDto> findPostSummary(String username);
}
