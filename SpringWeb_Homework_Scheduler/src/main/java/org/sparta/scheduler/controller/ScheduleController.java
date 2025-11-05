package org.sparta.scheduler.controller;

import lombok.RequiredArgsConstructor;
import org.sparta.scheduler.dto.*;
import org.sparta.scheduler.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
// - Property
    private final ScheduleService scheduleService;

    // - Create
    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> create(@RequestBody CreateScheduleRequest request) {
        CreateScheduleResponse result = scheduleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // - Read
    @GetMapping("/schedules")
    public ResponseEntity<List<GetScheduleResponse>> getAll(@RequestParam(required = false) String author) {
        List<GetScheduleResponse> result = scheduleService.getAll(author);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetScheduleResponse> getOne(@PathVariable Long scheduleId) {
        GetScheduleResponse result = scheduleService.getOne(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // - Update
    // - Delete
}