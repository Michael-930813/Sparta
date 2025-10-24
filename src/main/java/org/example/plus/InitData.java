/*
package org.example.advance;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.advance.common.entity.Comment;
import org.example.advance.common.entity.Post;
import org.example.advance.common.entity.User;
import org.example.advance.common.enums.UserRoleEnum;
import org.example.advance.domain.comment.repository.CommentRepository;
import org.example.advance.domain.comment.service.CommentService;
import org.example.advance.domain.post.repository.PostRepository;
import org.example.advance.domain.post.service.PostService;
import org.example.advance.domain.user.repository.UserRepository;
import org.example.advance.domain.user.service.UserService;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;



    @PostConstruct
    @Transactional
    public void init() {

        User user1 = new User("김동현", passwordEncoder.encode("1234"), "user1@naver.com", UserRoleEnum.ADMIN);
        User user2 = new User("동현킴", passwordEncoder.encode("1234"), "user2@naver.com", UserRoleEnum.NORMAL);

        userRepository.save(user1);
        userRepository.save(user2);

        Post post1 = new Post("1번 게시글", user1);
        Post post2 = new Post("2번 게시글", user1);
        Post post3 = new Post("2번 게시글", user1);
        Post post4 = new Post("2번 게시글", user1);
        Post post5 = new Post("2번 게시글", user1);
        Post post6 = new Post("2번 게시글", user1);
        Post post7 = new Post("2번 게시글", user1);
        Post post8 = new Post("2번 게시글", user1);
        Post post9 = new Post("2번 게시글", user1);

        Post post10 = new Post("3번 게시글", user2);

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
        postRepository.save(post4);
        postRepository.save(post5);
        postRepository.save(post6);
        postRepository.save(post7);
        postRepository.save(post8);
        postRepository.save(post9);
        postRepository.save(post10);

        // 여러분들이 배달음식 시켜먹은 횟수를 구하는 api를 호출했다.
        // 100번 * N
        // 100명
        // 1만번 나간다.
        //


        Comment comment1 = new Comment("댓글 1번", post1);
        Comment comment2 = new Comment("댓글 2번", post1);
        Comment comment3 = new Comment("댓글 3번", post2);
        Comment comment4 = new Comment("댓글 4번", post2);
        Comment comment5 = new Comment("댓글 5번", post3);
        Comment comment6 = new Comment("댓글 6번", post3);
        Comment comment7 = new Comment("댓글 7번", post3);

        commentRepository.save(comment1);
        commentRepository.save(comment2);
        commentRepository.save(comment3);
        commentRepository.save(comment4);
        commentRepository.save(comment5);
        commentRepository.save(comment6);
        commentRepository.save(comment7);

    }
}
*/
