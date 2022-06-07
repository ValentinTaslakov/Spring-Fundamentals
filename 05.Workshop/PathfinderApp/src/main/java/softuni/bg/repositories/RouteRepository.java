package softuni.bg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.bg.model.entities.Route;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long > {

    @Query("SELECT r FROM Route r ORDER BY size(r.comments) DESC")
    List<Route> findMostCommented();

    Optional<Route> findById(Long id);
}
