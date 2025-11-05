package org.sparta.scheduler.controller;

import lombok.RequiredArgsConstructor;
import org.sparta.scheduler.dto.*;
import org.sparta.scheduler.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    // - Update
    // - Delete
}