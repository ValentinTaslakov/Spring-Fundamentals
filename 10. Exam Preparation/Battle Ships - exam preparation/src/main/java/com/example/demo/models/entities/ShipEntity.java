package com.example.demo.models.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class ShipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Long health;

    @Column(nullable = false)
    private Long power;

    @Column(nullable = false)
    private LocalDate created;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private CategoryEntity categoryEntity;

    public ShipEntity() {}

    public Long getId() {
        return id;
    }

    public ShipEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipEntity setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipEntity setPower(Long power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipEntity setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public ShipEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public CategoryEntity getCategory() {
        return categoryEntity;
    }

    public ShipEntity setCategory(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
        return this;
    }
}
