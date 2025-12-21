package org.example.plus;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.example.plus.common.entity.Post;
import org.example.plus.common.entity.User;
import org.example.plus.common.enums.UserRoleEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.example.plus.common.entity.QPost.post;
import static org.example.plus.common.entity.QUser.user;

@SpringBootTest
@Transactional
public class QeuryDSLSearchTest {
// - Properties
    @Autowired
    JPAQueryFactory queryFactory;

// - Methods
    // - Basic
    @Test
    @DisplayName("목표 : NORMAL 사용자 중 gmail.com 이메일을 가진 사용자 조회")
    void test_case01() {
        List<User> result = queryFactory
                .selectFrom(user)
                .where(
                        user.roleEnum.eq(UserRoleEnum.NORMAL),
                        user.email.endsWith("gmail.com")
                )
                .fetch();

        System.out.println("검색완료");
    }

    // - OrderBy, Limit
    @Test
    @DisplayName("목표 : 사용자 이름 오름차순, ID 내림차순 정렬 후 3명만 조회")
    void test_case02() {
        List<User> result = queryFactory
                .selectFrom(user)
                .orderBy(user.username.asc(), user.id.desc())
                .limit(3)
                .fetch();

        System.out.println("검색완료");
    }

    // - Like "%여행%"
    @Test
    @DisplayName("목표 : “여행” 키워드가 포함된 게시글(Post) 조회")
    void test_case03() {
        List<Post> result = queryFactory
                .selectFrom(post)
                .where(post.content.contains("여행"))
                .fetch();

        System.out.println("검색완료");
    }

    // - Logic Combination
    @Test
    @DisplayName("목표: ADMIN 사용자 또는 이름에 “밥”이 포함된 사용자 조회")
    void test_case04() {
        List<User> result = queryFactory
                .selectFrom(user)
                .where(
                        user.roleEnum.eq(UserRoleEnum.ADMIN)
                                .or(user.username.contains("밥"))
                )
                .fetch();

        System.out.println("검색완료");
    }

    // - Join
    @Test
    @DisplayName("목표: “앨리스”가 작성한 게시글(Post) 조회")
    void test_case05() {
        List<Post> result = queryFactory
                .selectFrom(post)
                .join(post.user, user)
                .where(user.username.eq("앨리스"))
                .fetch();

        System.out.println("검색완료");
    }

    // - Fetch Join
    @Test
    @DisplayName("목표: 게시글과 작성자 정보를 한 번에 로딩")
    void test_case06() {
        List<Post> result = queryFactory
                .selectFrom(post)
                .join(post.user, user).fetchJoin()
                .fetch();

        System.out.println("검색완료");
    }

    // - Paging
    @Test
    @DisplayName("목표: 게시글 목록을 5개씩 조회 (2페이지: 6~10번 게시글)")
    void test_case07() {
        List<Post> page2 = queryFactory
                .selectFrom(post)
                .orderBy(post.id.asc())
                .offset(5)
                .limit(5)
                .fetch();

        System.out.println("검색완료");
    }
}
