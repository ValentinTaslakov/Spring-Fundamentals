package com.likebookapp.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "moods")
public class Mood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true,nullable = false)
    @Enumerated(EnumType.STRING)
    private MoodType name;

    private String description;

    public Mood() {}

    public Mood(MoodType name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MoodType getName() {
        return name;
    }

    public void setName(MoodType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
