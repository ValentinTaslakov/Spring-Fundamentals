package softuni.bg.model.entities;

import softuni.bg.model.enums.RoleName;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private RoleName role;

    public Role(){}

    public long getId() {
        return id;
    }

    public Role setId(long id) {
        this.id = id;
        return this;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }
}
