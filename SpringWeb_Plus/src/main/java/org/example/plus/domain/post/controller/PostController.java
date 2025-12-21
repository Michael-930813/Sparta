package org.example.plus.domain.post.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.plus.domain.post.model.dto.PostDto;
import org.example.plus.domain.post.model.dto.PostSummaryDto;
import org.example.plus.domain.post.model.request.CreatePostRequest;
import org.example.plus.domain.post.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@AuthenticationPrincipal User user, @RequestBody CreatePostRequest request) {
        return ResponseEntity.ok(postService.creatPost(user.getUsername(), request.getContent()));
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<PostDto>> getPostListByUsername(@PathVariable String username) {
        return ResponseEntity.ok(postService.getPostListByUsername(username));
    }


    //특정 사용자가 작성한 게시글에 달린 댓글의 갯수를 구하는 기능을 만들어주세요.
    @GetMapping("/user/{username}/detail")
    public ResponseEntity<List<PostSummaryDto>> getPostListDetailByUsername(@PathVariable String username) {
        return ResponseEntity.ok(postService.getPostSummaryListByUsername(username));
    }

}
