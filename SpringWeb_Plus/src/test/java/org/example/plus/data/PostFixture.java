package org.example.plus.data;

import org.example.plus.common.entity.Post;
import org.springframework.test.util.ReflectionTestUtils;

public class PostFixture {

    public static String DEFAULT_POST_CONTENT = "테스트 게시글 입니다.";

    public static Post createPost1() {
        Post post = new Post(DEFAULT_POST_CONTENT, UserFixture.createUserAdminRole());
        ReflectionTestUtils.setField(post, "id", 1L);
        return post;
    }
    public static Post createPost2() {
        Post post = new Post(DEFAULT_POST_CONTENT, UserFixture.createUserAdminRole());
        ReflectionTestUtils.setField(post, "id", 2L);
        return post;
    }
}
