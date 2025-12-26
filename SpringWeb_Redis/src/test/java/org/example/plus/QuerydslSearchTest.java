package org.example.plus;

import static org.example.plus.common.entity.QPost.post;
import static org.example.plus.common.entity.QUser.user;

import com.querydsl.jpa.JPQLQueryFactory;
import jakarta.transaction.Transactional;
import java.util.List;
import org.example.plus.common.entity.Post;
import org.example.plus.common.entity.User;
import org.example.plus.common.enums.UserRoleEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class QuerydslSearchTest {

    @Autowired
    JPQLQueryFactory queryFactory;

    @Test
    @DisplayName("기본 검색 쿼리 작성 예시")
    void test_case1() {

        List<User> result = queryFactory
            .selectFrom(user)
            .where(
                user.roleEnum.eq(UserRoleEnum.NORMAL),
                user.email.endsWith("gmail.com")
            )
            .fetch();

        System.out.println(result);
    }

    @Test
    @DisplayName("정렬과 페이징")
    void test_case2() {

        List<User> result = queryFactory
            .selectFrom(user)
            .orderBy(user.id.desc())
            .limit(1)
            .offset(2)
            .fetch();

        System.out.println(result.toString());
    }

    @Test
    @DisplayName("여행” 키워드가 포함된 게시글(Post) 조회")
    void test_case3() {

        List<Post> result = queryFactory
            .selectFrom(post)
            .where(post.content.contains("여행"))
            .fetch();

        System.out.println(result.get(0).getUser().getUsername());
        System.out.println(result);
    }

    @Test
    @DisplayName("ADMIN 사용자 또는 이름에 “밥”이 포함된 사용자 조회")
    void test_case4() {


        List<User> result = queryFactory
            .selectFrom(user)
            .where(
                user.roleEnum.eq(UserRoleEnum.ADMIN)
                    .or(user.username.contains("밥"))
            )
            .fetch();

        System.out.println(result);
    }
}
