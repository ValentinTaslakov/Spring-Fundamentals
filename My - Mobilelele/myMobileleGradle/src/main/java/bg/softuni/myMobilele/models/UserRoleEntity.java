package bg.softuni.myMobilele.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public UserRoleEntity setName(String name) {
        this.name = name;
        return this;
    }
}
