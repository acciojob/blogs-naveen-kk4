package com.driver.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name="blogs")
@Entity

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    String content;
    @CreationTimestamp
    private Date pubDate;
    @ManyToOne
    @JoinColumn
    private User user;
    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    private List<Image> imageList = new ArrayList<>();

    public void setUser(User user) {
        this.user = user;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public User getUser() {
        return user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public Blog() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public Blog(int id, String title, String content, Date pubDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
    }
}
