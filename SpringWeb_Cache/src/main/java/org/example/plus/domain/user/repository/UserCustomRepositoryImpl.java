package org.example.plus.domain.user.repository;

import static org.example.plus.common.entity.QUser.user;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.plus.common.enums.UserRoleEnum;
import org.example.plus.domain.user.model.request.UserSearchRequest;
import org.example.plus.domain.user.model.response.UserSearchResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class UserCustomRepositoryImpl implements UserCustomRepository {

    private final JPAQueryFactory queryFactory;


    private BooleanExpression usernameContains(String username) {
        return username != null ? user.username.contains(username) : null;
    }

    private BooleanExpression emailContains(String email) {
        return email != null ? user.email.contains(email) : null;
    }

    private BooleanExpression roleEq(UserRoleEnum role) {
        return role != null ? user.roleEnum.eq(role) : null;
    }

    @Override
    public List<UserSearchResponse> searchUserByMultiCondition(UserSearchRequest request) {
        return queryFactory
            .select(Projections.constructor(UserSearchResponse.class,
                user.username,
                user.email,
                user.roleEnum))
            .from(user)
            .where(
                usernameContains(request.getUsername()),
                emailContains(request.getEmail()),
                roleEq(request.getRole())
            )
            .orderBy(user.username.asc())
            .fetch();
    }



    @Override
    public List<UserSearchResponse> searchUserByMultiConditionV2(UserSearchRequest request, Pageable pageable) {

        BooleanBuilder builder = new BooleanBuilder();

        if (request.getUsername() != null && !request.getUsername().isBlank()) {
            builder.and(user.username.contains(request.getUsername()));
        }

        if (request.getEmail() != null && !request.getEmail().isBlank()) {
            builder.and(user.email.contains(request.getEmail()));
        }

        if (request.getRole() != null) {
            builder.and(user.roleEnum.eq(request.getRole()));
        }

        return queryFactory
            .select(Projections.constructor(UserSearchResponse.class,
                user.username,
                user.email,
                user.roleEnum))
            .from(user)
            .where(builder)
            .orderBy(user.username.asc())
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();
    }

    @Override
    public Page<UserSearchResponse> searchUserByMultiConditionPage(UserSearchRequest request, Pageable pageable) {

        BooleanBuilder builder = new BooleanBuilder();

        if (request.getUsername() != null && !request.getUsername().isBlank()) {
            builder.and(user.username.contains(request.getUsername()));
        }

        if (request.getEmail() != null && !request.getEmail().isBlank()) {
            builder.and(user.email.contains(request.getEmail()));
        }

        if (request.getRole() != null) {
            builder.and(user.roleEnum.eq(request.getRole()));
        }

        // ✅ 1) 실제 데이터 조회
        List<UserSearchResponse> content = queryFactory
            .select(Projections.constructor(UserSearchResponse.class,
                user.username,
                user.email,
                user.roleEnum))
            .from(user)
            .where(builder)
            .orderBy(user.username.asc())
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        // ✅ 2) 전체 카운트 조회
        Long total = queryFactory
            .select(user.count())
            .from(user)
            .where(builder)
            .fetchOne();

        // ✅ 4) total이 null일 경우 NPE 발생 방지
        if (total == null) {
            total = 0L;
        }

        // ✅ 4) Page 객체로 변환
        return new PageImpl<>(content, pageable, total);
    }

}