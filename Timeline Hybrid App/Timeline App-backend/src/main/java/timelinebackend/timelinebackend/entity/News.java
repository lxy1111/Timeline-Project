package timelinebackend.timelinebackend.entity;

/**
 * @Author: Fang Kun
 */

public class News {

    private int id;
    private String content;
    private String imageURL;
    private String author;
    private String time;

    public News(int id, String content, String imageURL, String author, String time) {
        this.id=id;
        this.content=content;
        this.author=author;
        this.imageURL=imageURL;
        this.time=time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
