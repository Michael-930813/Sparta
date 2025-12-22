package org.example.plus.domain.user.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.plus.common.enums.UserRoleEnum;
import org.example.plus.domain.user.model.request.UserSearchRequest;
import org.example.plus.domain.user.model.response.UserSearchResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.example.plus.common.entity.QUser.user;

@RequiredArgsConstructor
public class UserCustomRepositoryImpl implements UserCustomRepository {
// - Properties
    private final JPAQueryFactory jpaQueryFactory;

// - Methods
    @Override
    public List<UserSearchResponse> searchUserByMultiCondition(UserSearchRequest request) {
        // - Builder 방식
        BooleanBuilder builder = new BooleanBuilder();

        if (request.getUsername() != null && !request.getUsername().isBlank()) {
            builder.and(user.username.eq(request.getUsername()));
        }

        if (request.getEmail() != null && !request.getEmail().isBlank()) {
            builder.and(user.email.endsWith(request.getEmail()));
        }

        if (request.getRole() != null) {
            builder.and(user.roleEnum.eq(request.getRole()));
        }

        return jpaQueryFactory
                .select(Projections.constructor(UserSearchResponse.class,
                        user.username,
                        user.email,
                        user.roleEnum))
                .from(user)
                .where(builder)
                .orderBy(user.username.asc())
                .fetch();
    }

    // - BooleanExpression
    public List<UserSearchResponse> searchUserByMultiCondition2(UserSearchRequest request) {
        return jpaQueryFactory
                .select(Projections.constructor(UserSearchResponse.class,
                        user.username,
                        user.email,
                        user.roleEnum))
                .from(user)
                .where(
                        usernameCondition(request.getUsername()),
                        emailCondition(request.getEmail()),
                        roleCondition(request.getRole())
                )
                .fetch();
    }

    private BooleanExpression usernameCondition(String username) {
        return username != null ? user.username.eq(username) : null;
    }
    private BooleanExpression emailCondition(String email) {
        return email != null ? user.email.eq(email) : null;
    }
    private BooleanExpression roleCondition(UserRoleEnum role) {
        return  role != null ? user.roleEnum.eq(role) : null;
    }

    // - Pageable
    @Override
    public Page<UserSearchResponse> searchUserByMultiConditionPage(UserSearchRequest request, Pageable pageable) {
        // - 1. 실제 데이터 값
        List<UserSearchResponse> result =  jpaQueryFactory
                .select(Projections.constructor(UserSearchResponse.class,
                        user.username,
                        user.email,
                        user.roleEnum))
                .from(user)
                .where(
                        usernameCondition(request.getUsername()),
                        emailCondition(request.getEmail()),
                        roleCondition(request.getRole())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        // - 2. 전체 데이터 갯수
        Long total = jpaQueryFactory
                .select(user.count())
                .from(user)
                .where(
                        usernameCondition(request.getUsername()),
                        emailCondition(request.getEmail()),
                        roleCondition(request.getRole())
                ).fetchOne();
        // - Check null
        if (total == null) { total = 0L; }

        // - 3. Page 객체로 변환
        return new PageImpl<>(result, pageable, total);
    }
}
