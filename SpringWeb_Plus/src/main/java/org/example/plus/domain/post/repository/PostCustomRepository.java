package org.example.plus.domain.post.repository;

import org.example.plus.domain.post.model.dto.PostSummaryDto;

import java.util.List;

public interface PostCustomRepository {
    List<PostSummaryDto> finPostSummary(String username);
}
