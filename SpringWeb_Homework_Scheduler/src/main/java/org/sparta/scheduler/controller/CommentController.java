package org.sparta.scheduler.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sparta.scheduler.dto.*;
import org.sparta.scheduler.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
// - Property
    private final CommentService commentService;

// - Moethod
    // - Create
    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CreateCommentResponse> create(@PathVariable Long scheduleId, @Valid @RequestBody CreateCommentRequest request) {
        CreateCommentResponse result = commentService.save(scheduleId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    // - Read
    @GetMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<List<GetCommentResponse>> getAll() {
        List<GetCommentResponse> result = commentService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    // - Update
    // - Delete
}
