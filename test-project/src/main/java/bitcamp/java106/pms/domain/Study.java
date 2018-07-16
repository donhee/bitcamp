package bitcamp.java106.pms.domain;

import java.io.Serializable;

public class Study implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int no;
    private String title;
    private String description;
    
    @Override
    public String toString() {
        return "study [no=" + no + ", title=" + title + ", description=" + description + "]";
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
    
}
