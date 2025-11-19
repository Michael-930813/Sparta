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
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(nullable = false, length = 20)
    private String password;

// - Methods
    // - Constructor
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public User(CreateUserRequest request) {
        this.name = request.getName();
        this.email = request.getEmail();
        this.password = request.getPassword();
    }

    // - Update
    public void update(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public void update(UpdateUserRequest request) {
        this.name = request.getName();
        this.email = request.getEmail();
        this.password = request.getPassword();
    }
}
