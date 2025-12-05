package sparta.domain.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sparta.domain.comment.model.dto.CommentDto;
import sparta.domain.comment.service.CommentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {
// - Properties
    private final CommentService commentService;

// - Methods
    // - Create
    @PostMapping("/{postId}")
    public ResponseEntity<CommentDto> createComment(@PathVariable Long postId, @RequestBody CommentDto request) {
        return ResponseEntity.ok(commentService.createComment(postId, request.getContent()));
    }
    // - Read
    // - Update
    // - Delete
}
