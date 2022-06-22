package com.example.demo.models.entities;

import com.example.demo.models.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryEnum name;

    @Lob
    private String description;

    public CategoryEntity() {}

    public Long getId() {
        return id;
    }

    public CategoryEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public CategoryEnum getName() {
        return name;
    }

    public CategoryEntity setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
