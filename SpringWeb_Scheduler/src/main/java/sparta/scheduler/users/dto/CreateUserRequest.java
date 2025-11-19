package sparta.scheduler.users.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateUserRequest {
// - Properties
    private  String name;
    private  String email;
}
