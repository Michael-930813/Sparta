package sparta.scheduler.schedules.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateScheduleRequest {
// - Properties
    private String author;
    private String title;
    private String description;
}
