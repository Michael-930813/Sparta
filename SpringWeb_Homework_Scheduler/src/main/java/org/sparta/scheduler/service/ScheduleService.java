package org.sparta.scheduler.service;

import org.sparta.scheduler.entity.Schedule;
import org.sparta.scheduler.dto.*;
import org.sparta.scheduler.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
// - Property
    private final ScheduleRepository scheduleRepository;

// - Method
    // - Create
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(request);
        Schedule saved = scheduleRepository.save(schedule);
        return new CreateScheduleResponse(saved);
    }
    // - Read
    @Transactional(readOnly = true)
    public List<GetScheduleResponse> getAll(String author) {
        List<Schedule> schedules;

        if (author != null && !author.isBlank()) {
            schedules = scheduleRepository.findAllByAuthorOrderByModifiedAtDesc(author);
        } else {
            schedules = scheduleRepository.findAllByOrderByModifiedAtDesc();
        }

        List<GetScheduleResponse> dtos = new ArrayList<>();

        for (Schedule schedule : schedules) {
            dtos.add(new GetScheduleResponse(schedule));
        }

        return dtos;
    }
    @Transactional(readOnly = true)
    public GetScheduleResponse getOne(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다.")
        );
        return new GetScheduleResponse(schedule);
    }
    // - Update
    // - Delete
}
