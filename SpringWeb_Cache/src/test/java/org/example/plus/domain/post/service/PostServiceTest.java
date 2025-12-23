package org.example.plus.domain.post.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.example.plus.data.UserFixture.DEFAULT_USERNAME;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import org.example.plus.common.entity.Post;
import org.example.plus.common.entity.User;
import org.example.plus.data.PostFixture;
import org.example.plus.data.UserFixture;
import org.example.plus.domain.post.model.dto.PostDto;
import org.example.plus.domain.post.repository.PostRepository;
import org.example.plus.domain.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PostService postService;

    private User testUser;


    @BeforeEach
    void setUp() {

        testUser = UserFixture.createUserAdminRole();
    }


    // 게시글 생성 단위 테스트 진행

    @Test
    @DisplayName("게시글 생성 성공 - 유효한 사용자와 내용이 주어졌을 때 - 성공케이스")
    void createPost_success() {

        // given

        Post testPost = PostFixture.createPost1();


        when(userRepository.findUserByUsername(testUser.getUsername())).thenReturn(Optional.of(testUser));
        when(postRepository.save(any(Post.class))).thenReturn(testPost);

        // when
        PostDto result = postService.creatPost(testUser.getUsername(), testPost.getContent());

        // then
        assertThat(result).isNotNull();
        assertThat(result.getContent()).isEqualTo(testPost.getContent());
        assertThat(result.getId()).isEqualTo(testPost.getId());
        assertThat(result.getUsername()).isEqualTo(DEFAULT_USERNAME);

        verify(postRepository, times(1)).save(any(Post.class));

    }

    @Test
    @Disabled
    @DisplayName("사용자 명으로 게시글 목록 조회 - 성공")
    void getPostListByUsername_success() {

        // given

        List<Post> postList = List.of(
           PostFixture.createPost1(),
           PostFixture.createPost2()
        );


        // testUser.getPosts().addAll(postList);


        when(userRepository.findUserByUsername(DEFAULT_USERNAME)).thenReturn(Optional.of(testUser));

        // when

        List<PostDto> result = postService.getPostListByUsername(DEFAULT_USERNAME);


        // then
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getUsername()).isEqualTo(DEFAULT_USERNAME);
        assertThat(result.get(0).getContent()).isEqualTo("테스트 게시글 1");
        assertThat(result.get(1).getContent()).isEqualTo("테스트 게시글 2");

    }

    @Test
    @DisplayName("사용자 명으로 게시글 목록 조회 - 실패 - 사용자가 없는 경우")
    void getPostListByUsername_fail_case1() {

        // given
        when(userRepository.findUserByUsername(DEFAULT_USERNAME)).thenReturn(Optional.empty());

        // when & then
        assertThatThrownBy(() -> postService.getPostListByUsername(DEFAULT_USERNAME))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("등록된 사용자가 없습니다.");

    }

}