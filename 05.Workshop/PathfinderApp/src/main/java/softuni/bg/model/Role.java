package softuni.bg.model;

import softuni.bg.model.enums.RoleName;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private RoleName name;

    public Role(){}

    public long getId() {
        return id;
    }

    public Role setId(long id) {
        this.id = id;
        return this;
    }

    public RoleName getName() {
        return name;
    }

    public Role setName(RoleName name) {
        this.name = name;
        return this;
    }
}
