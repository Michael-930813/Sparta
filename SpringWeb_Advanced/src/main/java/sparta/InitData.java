package sparta;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sparta.common.entity.Comment;
import sparta.common.entity.Post;
import sparta.common.entity.User;
import sparta.common.enums.UserRoleEnum;
import sparta.domain.comment.repository.CommentRepository;
import sparta.domain.post.repository.PostRepository;
import sparta.domain.user.repository.UserRepository;
import sparta.domain.user.service.UserService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {
// - Properties
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

// - Methods
    @PostConstruct
    @Transactional
    public void init() {
        User user1 = new User("테스트",passwordEncoder.encode("1234"),"user1@sparta.com", UserRoleEnum.NORMAL);
        User user2 = new User("트스테",passwordEncoder.encode("1234"),"user2@sparta.com",UserRoleEnum.ADMIN);

        userRepository.save(user1);
        userRepository.save(user2);

        Post post1 = new Post("1번 게시물", user1);
        Post post2 = new Post("2번 게시물", user1);
        Post post3 = new Post("3번 게시물", user2);

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        Comment comment1 = new Comment("댓글 1번", post1);
        Comment comment2 = new Comment("댓글 2번", post1);
        Comment comment3 = new Comment("댓글 3번", post1);
        Comment comment4 = new Comment("댓글 4번", post2);
        Comment comment5 = new Comment("댓글 5번", post2);
        Comment comment6 = new Comment("댓글 6번", post2);
        Comment comment7 = new Comment("댓글 7번", post3);
        Comment comment8 = new Comment("댓글 8번", post3);
        Comment comment9 = new Comment("댓글 9번", post3);
        Comment comment10 = new Comment("댓글 10번", post3);

        commentRepository.save(comment1);
        commentRepository.save(comment2);
        commentRepository.save(comment3);
        commentRepository.save(comment4);
        commentRepository.save(comment5);
        commentRepository.save(comment6);
        commentRepository.save(comment7);
        commentRepository.save(comment8);
        commentRepository.save(comment9);
        commentRepository.save(comment10);
    }
}
