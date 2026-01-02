package org.example.plus.domain.post.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.plus.domain.post.model.dto.PostDto;
import org.example.plus.domain.post.model.dto.PostSummaryDto;
import org.example.plus.domain.post.model.request.CreatePostRequest;
import org.example.plus.domain.post.model.request.UpdatePostRequest;
import org.example.plus.domain.post.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@AuthenticationPrincipal User user, @RequestBody CreatePostRequest request) {
        return ResponseEntity.ok(postService.creatPost(user.getUsername(), request.getContent()));
    }

    // - Redis
    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }
    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> updatePostById(@PathVariable Long postId, @RequestBody UpdatePostRequest request) {
        return ResponseEntity.ok(postService.updatePostById(postId, request));
    }

    // - Get Popular Posts
    @GetMapping("/popular")
    public ResponseEntity<List<PostDto>> getPopularPostList(@RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(postService.getTopPostList(limit));
    }
}
