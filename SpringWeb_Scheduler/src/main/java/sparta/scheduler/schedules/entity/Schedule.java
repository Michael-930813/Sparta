package sparta.scheduler.schedules.entity;

import jakarta.persistence.*;
import lombok.*;
import sparta.scheduler.common.BaseEntity;
import sparta.scheduler.schedules.dto.*;
import sparta.scheduler.users.entity.User;

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
    private String title;
    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

// - Methods
    // - Constructor
    public Schedule(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }
    public Schedule(CreateScheduleRequest request, User user) {
        this.title = request.getTitle();
        this.description = request.getDescription();
        this.user = user;
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
