package sparta.scheduler.schedules.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleRequest {
    private Long userId;
    private String title;
    private String description;
}
