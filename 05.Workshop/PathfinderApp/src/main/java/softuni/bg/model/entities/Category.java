package softuni.bg.model.entities;

import softuni.bg.model.enums.RouteCategory;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RouteCategory name;

    @Column(columnDefinition = "TEXT")
    private String description;




    public Category() {}

    public long getId() {
        return id;
    }

    public Category setId(long id) {
        this.id = id;
        return this;
    }

    public RouteCategory getName() {
        return name;
    }

    public Category setName(RouteCategory name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
