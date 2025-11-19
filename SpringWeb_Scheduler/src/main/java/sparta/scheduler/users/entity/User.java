package sparta.scheduler.users.entity;

import jakarta.persistence.*;
import lombok.*;
import sparta.scheduler.common.BaseEntity;
import sparta.scheduler.users.dto.*;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
// - Properties
    @Id     // - PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;

// - Methods
    // - Constructor
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public User(CreateUserRequest request) {
        this.name = request.getName();
        this.email = request.getEmail();
    }

    // - Update
    public void update(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public void update(UpdateUserRequest request) {
        this.name = request.getName();
        this.email = request.getEmail();
    }
}
