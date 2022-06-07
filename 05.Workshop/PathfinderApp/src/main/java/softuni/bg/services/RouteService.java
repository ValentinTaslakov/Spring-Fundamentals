package softuni.bg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.bg.model.entities.Route;
import softuni.bg.repositories.RouteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {
    private final RouteRepository routeRepository;


    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<Route> getMostCommented(){
        return routeRepository.findMostCommented();
    }

    public Optional<Route> getRouteById(Long id){
        return routeRepository.findById(id);
    }
}
