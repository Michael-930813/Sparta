package org.example.plus.domain.post.service;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.transaction.Transactional;
import java.util.List;
import org.example.plus.common.entity.Post;
import org.example.plus.common.entity.User;
import org.example.plus.data.UserFixture;
import org.example.plus.domain.post.model.dto.PostDto;
import org.example.plus.domain.post.repository.PostRepository;
import org.example.plus.domain.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class PostServiceIntegrationTest {

    @Autowired
    private PostService postService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("게시글 생성 통합 테스트 - 실제 DB에 저장 및 조회 검증")
    void createPost_통합테스트_success() {

        // given
        User user = UserFixture.createUserAdminRole();
        userRepository.save(user);

        // when
        PostDto result = postService.creatPost(user.getUsername(),"테스트 게시글 입니다.");


        // then
        List<Post> savePostList = postRepository.findAll();

        assertThat(savePostList).hasSize(1);
        assertThat(savePostList.get(0).getContent()).isEqualTo("테스트 게시글 입니다.");

    }

}