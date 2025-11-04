package org.sparta.scheduler.controller;

import lombok.RequiredArgsConstructor;
import org.sparta.scheduler.service.ScheduleService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
// - Property
    private final ScheduleService scheduleService;
}
