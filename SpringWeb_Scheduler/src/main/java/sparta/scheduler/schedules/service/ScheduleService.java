package sparta.scheduler.schedules.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.scheduler.schedules.dto.*;
import sparta.scheduler.schedules.entity.Schedule;
import sparta.scheduler.schedules.repository.ScheduleRepository;
import sparta.scheduler.users.entity.User;
import sparta.scheduler.users.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
// - Properties
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    // - Methods
    // - Create
    @Transactional
    public CreateScheduleResponse create(CreateScheduleRequest request) {
        User user = findUserById(request.getUserId());
        Schedule schedule = new Schedule(request, user);
        Schedule saved = scheduleRepository.save(schedule);
        return new CreateScheduleResponse(saved);
    }
    // - Read (All & One)
    @Transactional(readOnly = true)
    public List<GetScheduleResponse> getAll(Long userId) {
        List<Schedule> schedules;

        if (userId != null && userId > 0) {
            schedules = scheduleRepository.findAllByUserIdOrderByCreatedAtDesc(userId);
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

    // - FindUserFromId
    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("User with id " + userId + " not found")
        );
    }
    // - FindScheduleFromId
    public Schedule findScheduleById(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다!!")
        );
    }
}
