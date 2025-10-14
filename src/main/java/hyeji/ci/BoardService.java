import java.util.ArrayList;
import java.util.List;

public class BoardService {
    private List<Post> posts = new ArrayList<>();

    public void addPost(String title, String content) {
        if (title == null || title.isEmpty() || content == null || content.isEmpty()) {
            throw new IllegalArgumentException("제목과 내용은 비어 있을 수 없습니다. 내용을 추가해주세요!");
        }
        posts.add(0, new Post(title, content)); // 최신글을 앞에 추가
    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts); // 복사본 반환
    }

    public int getPostCount() {
        return posts.size();
    }
}
