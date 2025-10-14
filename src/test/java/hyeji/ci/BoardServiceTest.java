import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardServiceTest {

    private BoardService boardService;

    @BeforeEach
    public void setup() {
        boardService = new BoardService();
    }

    @Test
    public void testAddPostSuccess() {
        boardService.addPost("제목1", "내용1");
        assertEquals(1, boardService.getPostCount());

        // 게시글 내용 검증
        assertEquals("제목1", boardService.getPosts().get(0).getTitle());
        assertEquals("내용1", boardService.getPosts().get(0).getContent());
    }

    @Test
    public void testAddPostEmptyTitle() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            boardService.addPost("", "내용");
        });
        assertEquals("제목과 내용은 비어 있을 수 없습니다. 내용을 추가해주세요.", exception.getMessage());
    }

    @Test
    public void testAddPostEmptyContent() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            boardService.addPost("제목", "");
        });
        assertEquals("제목과 내용은 비어 있을 수 없습니다. 내용을 추가해주세요.", exception.getMessage());
    }
}
