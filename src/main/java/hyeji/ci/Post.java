package hyeji.ci;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private String title;
    private String content;
    private final List<Attachment> attachments = new ArrayList<>();

    public Post(String title, String content) { /* ...existing code... */ }

    // getter/setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
     public List<Attachment> getAttachments() {
         return new ArrayList<>(attachments);
     }
     public void addAttachment(Attachment a) {
         if (a != null) attachments.add(a);
     }
}
