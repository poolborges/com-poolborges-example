package repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Node {

    private Date created = new Date();
    private String source = "  unknown ";
    private String author = "unknown ";
    private List<String> contents = new ArrayList<String>();
    private String path;

    @Override
    public String toString() {
        String s = "node:path = " + getPath() + 
                " , author = " + getAuthor() + 
                ", created = " + getCreated() + 
                ", source = " + getSource() + 
                ", data =[";
        String separator = "";
        for (String d : getContents()) {
            s += separator + d;
            separator = ",";
        }
        s += "]";
        return s;
    }

    public Node() {
    }

    public Node(String content) {
        getContents().add(content);
    }

    public Node(String content, String context) {
        this(content);
        setSource(context);
    }

    // .. accessors and mutators go here.
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List contents) {
        this.contents = contents;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
}