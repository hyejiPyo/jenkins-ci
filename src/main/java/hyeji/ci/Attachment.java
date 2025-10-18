package hyeji.ci;

public class Attachment {
    private final String originalFilename;
    private final String storedPath;
    private final long size;
    private final String contentType;

    public Attachment(String originalFilename, String storedPath, long size, String contentType) {
        this.originalFilename = originalFilename;
        this.storedPath = storedPath;
        this.size = size;
        this.contentType = contentType;
    }

    public String getOriginalFilename() { return originalFilename; }
    public String getStoredPath() { return storedPath; }
    public long getSize() { return size; }
    public String getContentType() { return contentType; }
}