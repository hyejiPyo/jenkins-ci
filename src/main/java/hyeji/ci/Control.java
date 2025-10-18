package hyeji.ci;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Control {
    
    @GetMapping("/")
    public String home() {
        return "게시판 메인 페이지입니다!";
    }
}