package softuni.bg.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.bg.model.entities.Route;
import softuni.bg.services.RouteService;

import java.util.Optional;

@Controller
public class RouteDetailsController {

    private final RouteService routeService;

    @Autowired
    public RouteDetailsController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes/details/:id")
    public String routeDetails (Model model){

        Optional<Route> optionalRoute = routeService.getRouteById((long)1);
        Route route = optionalRoute.get();

        model.addAttribute("selectedRoute",route.getDescription());
        return "route-details";
    }
}
