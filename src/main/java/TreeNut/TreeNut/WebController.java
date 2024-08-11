package TreeNut.TreeNut
;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "index"; // templates/index.html을 반환
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // templates/login.html을 반환
    }
}
