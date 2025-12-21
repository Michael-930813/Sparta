package org.example.plus.domain.comment.controller;


import lombok.RequiredArgsConstructor;
import org.example.plus.domain.comment.model.dto.CommentDto;
import org.example.plus.domain.comment.model.request.CreateCommentRequest;
import org.example.plus.domain.comment.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{postId}")
    public ResponseEntity<CommentDto> createComment(@PathVariable long postId, @RequestBody CreateCommentRequest request) {
        return ResponseEntity.ok(commentService.createComment(postId, request.getContent()));
    }
}
