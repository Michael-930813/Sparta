package sparta.domain.post.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import sparta.domain.post.model.dto.PostDto;
import sparta.domain.post.model.dto.PostSummaryDto;
import sparta.domain.post.model.request.PostCreateRequestDto;
import sparta.domain.post.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {
// - Properties
    private final PostService postService;

// - Methods
    // - Create
    @PostMapping
    public ResponseEntity<PostDto> createPost(
            @AuthenticationPrincipal User user,
            @RequestBody PostCreateRequestDto request) {
        return ResponseEntity.ok(postService.createPost(user.getUsername(), request.getContent()));
    }
    // - Read
    @GetMapping("/user/{username}")
    public ResponseEntity<List<PostDto>> getPostListByUsername(@PathVariable String username) {
        return ResponseEntity.ok(postService.getPostListByUsername(username));
    }
    @GetMapping("/user/{username}/detail")
    public ResponseEntity<List<PostSummaryDto>> getPostListDetailByUsername(@PathVariable String username) {
        return ResponseEntity.ok(postService.getPostSummaryListByUsername(username));
    }
}
