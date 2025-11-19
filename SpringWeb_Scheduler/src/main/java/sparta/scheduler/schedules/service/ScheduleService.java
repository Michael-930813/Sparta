package sparta.scheduler.schedules.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.scheduler.schedules.dto.*;
import sparta.scheduler.schedules.entity.Schedule;
import sparta.scheduler.schedules.repository.ScheduleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
// - Properties
    private final ScheduleRepository scheduleRepository;

// - Methods
    // - Create
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(request);
        Schedule saved = scheduleRepository.save(schedule);
        return new CreateScheduleResponse(saved);
    }
    // - Read (All & One)
    @Transactional(readOnly = true)
    public List<GetScheduleResponse> getAll(String author) {
        List<Schedule> schedules;

        if (author != null && !author.isBlank()) {
            schedules = scheduleRepository.findAllByAuthorOrderByCreatedAtDesc(author);
        } else {
            schedules = scheduleRepository.findAllByOrderByCreatedAtDesc();
        }

        List<GetScheduleResponse> dtos = new ArrayList<>();

        for (Schedule schedule : schedules) {
            dtos.add(new GetScheduleResponse(schedule));
        }

        return dtos;
    }
    @Transactional(readOnly = true)
    public GetScheduleResponse getOne(Long scheduleId) {
        Schedule schedule = findScheduleById(scheduleId);
        return new GetScheduleResponse(schedule);
    }
    // - Update
    @Transactional
    public UpdateScheduleResponse update(Long scheduleId, UpdateScheduleRequest request) {
        Schedule schedule = findScheduleById(scheduleId);
        schedule.update(request);
        return new UpdateScheduleResponse(schedule);
    }
    // - Delete
    @Transactional
    public void delete(Long scheduleId) {
        Schedule schedule = findScheduleById(scheduleId);
        scheduleRepository.delete(schedule);
    }

    // - FindScheduleFromId
    public Schedule findScheduleById(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다!!")
        );
    }
}
