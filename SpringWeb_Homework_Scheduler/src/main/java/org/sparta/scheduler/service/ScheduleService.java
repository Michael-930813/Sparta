package org.sparta.scheduler.service;

import org.sparta.scheduler.entity.Schedule;
import org.sparta.scheduler.dto.*;
import org.sparta.scheduler.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {
// - Property
    private final ScheduleRepository scheduleRepository;

// - Method
    // - Create
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getDescription(),
                request.getAuthor(),
                request.getPassword()
        );
        Schedule saved = scheduleRepository.save(schedule);
        return new CreateScheduleResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getDescription(),
                saved.getAuthor(),
                saved.getCreatedAt(),
                saved.getModifiedAt()
        );
    }
    // - Read
    // - Update
    // - Delete
}
