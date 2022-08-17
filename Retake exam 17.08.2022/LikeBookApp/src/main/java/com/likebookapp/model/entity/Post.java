package com.likebookapp.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    private User creator;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<User> usersLikes;

    @ManyToOne
    private Mood mood;

    public Post() {}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<User> getUsersLikes() {
        return usersLikes;
    }

    public void setUsersLikes(User user) {
        this.usersLikes.add(user);
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }
}
