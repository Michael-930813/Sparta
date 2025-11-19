package sparta.scheduler.schedules.entity;

import jakarta.persistence.*;
import lombok.*;
import sparta.scheduler.common.BaseEntity;
import sparta.scheduler.schedules.dto.*;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {
// - Properties
    @Id     // - PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;

// - Methods
    // - Constructor
    public Schedule(String author, String title, String description) {
        this.author = author;
        this.title = title;
        this.description = description;
    }
    public Schedule(CreateScheduleRequest request) {
        this.author = request.getAuthor();
        this.title = request.getTitle();
        this.description = request.getDescription();
    }

    // - Update
    public void update(String title, String description) {
        this.title = title;
        this.description = description;
    }
    public void update(UpdateScheduleRequest request) {
        this.title = request.getTitle();
        this.description = request.getDescription();
    }
}
