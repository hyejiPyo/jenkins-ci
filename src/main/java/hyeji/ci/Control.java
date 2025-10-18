package hyeji.ci;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Control {

    private final BoardService boardService;

    public Control() {
        this.boardService = new BoardService();  // 간단하게 직접 생성 (스프링 DI 환경이라면 @Autowired 쓰면 됨)
    }

    @GetMapping("/")
    public List<Post> home() {
        return boardService.getPosts();  // 게시글 목록을 JSON 형태로 반환
    }
}