package softuni.bg.model;

import softuni.bg.model.enums.categoryName;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private categoryName name;

    @Lob
    private String description;

    public Category() {}

    public long getId() {
        return id;
    }

    public Category setId(long id) {
        this.id = id;
        return this;
    }

    public categoryName getName() {
        return name;
    }

    public Category setName(categoryName name) {
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
