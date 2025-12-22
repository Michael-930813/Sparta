package org.example.plus.domain.user.repository;

import org.example.plus.domain.user.model.request.UserSearchRequest;
import org.example.plus.domain.user.model.response.UserSearchResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserCustomRepository {
// - Methods(QueryDSL)
    List<UserSearchResponse> searchUserByMultiCondition(UserSearchRequest request);
    List<UserSearchResponse> searchUserByMultiCondition2(UserSearchRequest request);

    Page<UserSearchResponse> searchUserByMultiConditionPage(UserSearchRequest request, Pageable pageable);
}
