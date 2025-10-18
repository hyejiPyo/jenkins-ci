package hyeji.ci;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
     // 파일 업로드를 함께 처리하는 오버로드 메서드
     // fileData: 첨부파일 바이트 배열, originalFilename: 업로드된 원래 파일명
     public void addPost(String title, String content, byte[] fileData, String originalFilename) throws IOException {
         if (title == null || title.isEmpty() || content == null || content.isEmpty()) {
             throw new IllegalArgumentException("제목과 내용은 비어 있을 수 없습니다. 내용을 추가해주세요!");
         }
         Post post = new Post(title, content);
 
         if (fileData != null && originalFilename != null && !originalFilename.isEmpty()) {
             Path uploadsDir = Paths.get("uploads");
             Files.createDirectories(uploadsDir);
             String safeName = System.currentTimeMillis() + "_" + originalFilename.replaceAll("[^a-zA-Z0-9._-]", "_");
             Path stored = uploadsDir.resolve(safeName);
             Files.write(stored, fileData);
             long size = Files.size(stored);
             String contentType = Files.probeContentType(stored);
             Attachment a = new Attachment(originalFilename, stored.toString(), size, contentType);
             post.addAttachment(a);
         }
 
         posts.add(0, post);
     }
 
    public List<Post> getPosts() {
        return new ArrayList<>(posts); // 복사본 반환
    }

    public int getPostCount() {
        return posts.size();
    }
}
