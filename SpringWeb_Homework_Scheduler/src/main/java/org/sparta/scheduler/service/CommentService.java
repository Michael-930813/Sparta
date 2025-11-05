package org.sparta.scheduler.service;

import lombok.RequiredArgsConstructor;
import org.sparta.scheduler.dto.*;
import org.sparta.scheduler.entity.*;
import org.sparta.scheduler.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
// - Property
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

// - Method
    // - Create
    @Transactional
    public CreateCommentResponse save(Long scheduleId, CreateCommentRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("해당 일정이 없습니다.")
        );
        // - Check Comment Limit
        validateCommentLimit(scheduleId);
        // - Create Comment
        Comment comment = new Comment(
                request.getComment(),
                request.getAuthor(),
                request.getPassword(),
                schedule
        );

        Comment saved = commentRepository.save(comment);
        return new CreateCommentResponse(saved);
    }
    // - Read
    @Transactional(readOnly = true)
    public List<GetCommentResponse> getAll() {
        List<Comment> comments = commentRepository.findAllByOrderByCreatedAtDesc();
        List<GetCommentResponse> dtos = new ArrayList<>();
        for (Comment comment : comments) {
            dtos.add(new GetCommentResponse(comment));
        }
        return dtos;
    }
    // - Update
    // - Delete

    // - Functions
    // - Check CommentLimit
    private void validateCommentLimit(Long scheduleId) {
        Long count = commentRepository.countByScheduleId(scheduleId);
        if (count > 10) {
            throw new IllegalStateException("1개의 일정에 최대 10개의 댓글만 작성 가능합니다.");
        }
    }
}
