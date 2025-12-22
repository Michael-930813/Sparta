package sparta.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerTestController {
    @GetMapping("/test")
    public String test() {
        return "Docker Test Version2";
    }
}
