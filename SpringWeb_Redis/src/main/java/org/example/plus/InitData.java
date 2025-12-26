package org.example.plus;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

import org.example.plus.common.entity.Comment;
import org.example.plus.common.entity.Post;
import org.example.plus.common.entity.User;
import org.example.plus.common.enums.UserRoleEnum;
import org.example.plus.domain.comment.repository.CommentRepository;
import org.example.plus.domain.post.repository.PostRepository;
import org.example.plus.domain.user.repository.UserRepository;
import org.example.plus.domain.user.service.UserService;
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

        // --- 사용자 데이터 생성 ---
        User admin = new User("관리자", passwordEncoder.encode("admin123"), "admin@spring.com", UserRoleEnum.ADMIN);
        User alice = new User("앨리스", passwordEncoder.encode("1234"), "alice@gmail.com", UserRoleEnum.NORMAL);
        User bob = new User("밥", passwordEncoder.encode("1234"), "bob@naver.com", UserRoleEnum.NORMAL);
        User charlie = new User("찰리", passwordEncoder.encode("1234"), "charlie@gmail.com", UserRoleEnum.NORMAL);

        userRepository.saveAll(List.of(admin, alice, bob, charlie));

        // --- 게시글 데이터 생성 ---
        List<Post> posts = new ArrayList<>();

        // Admin의 공지 게시글
        posts.add(new Post("공지사항: 서버 점검 안내", admin.getId()));
        posts.add(new Post("스프링 부트 3.x 마이그레이션 가이드", admin.getId()));

        // Alice의 여행 블로그
        posts.add(new Post("후쿠오카 여행 후기", alice.getId()));
        posts.add(new Post("조호바루 맛집 탐방", alice.getId()));
        posts.add(new Post("싱가포르 출퇴근 일상", alice.getId()));

        // Bob의 개발 블로그
        posts.add(new Post("QueryDSL 실무 적용기", bob.getId()));
        posts.add(new Post("JPA 성능 튜닝 방법", bob.getId()));
        posts.add(new Post("Docker로 배포 환경 만들기", bob.getId()));

        // Charlie의 리뷰 게시글
        posts.add(new Post("리제로 3기 감상평", charlie.getId()));
        posts.add(new Post("롤체 시즌10 덱 분석", charlie.getId()));
        posts.add(new Post("카페에서 개발하기 좋은 노트북 추천", charlie.getId()));

        postRepository.saveAll(posts);

        // --- 댓글 데이터 생성 ---
        List<Comment> comments = new ArrayList<>();

        // Alice 게시글에 달린 댓글
        comments.add(new Comment("사진이 너무 예쁘네요!", posts.get(2).getId()));  // 후쿠오카 여행 후기
        comments.add(new Comment("저도 같은 곳 갔어요!", posts.get(2).getId()));
        comments.add(new Comment("조호바루 가보고 싶어요", posts.get(3).getId()));

        // Bob 게시글에 달린 댓글
        comments.add(new Comment("QueryDSL 너무 유용하네요", posts.get(5).getId()));
        comments.add(new Comment("튜닝 포인트 정리 감사합니다!", posts.get(6).getId()));

        // Charlie 게시글에 달린 댓글
        comments.add(new Comment("리제로 명작이죠", posts.get(8).getId()));
        comments.add(new Comment("롤체 요즘 너무 어렵네요", posts.get(9).getId()));
        comments.add(new Comment("맥북 M3 쓰는데 괜찮아요", posts.get(10).getId()));

        commentRepository.saveAll(comments);

    }
}
