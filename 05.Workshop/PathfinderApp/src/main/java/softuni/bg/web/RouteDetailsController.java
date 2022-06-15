package softuni.bg.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("/routes/details/:id?id=")
    @ResponseBody
    public String getRouteDetailsById (@RequestParam String id,
                                       Model model){

        Optional<Route> optionalRoute = routeService.getRouteById(Long.valueOf(id));
        Route route = optionalRoute.get();

        model.addAttribute("description",route);
        return "route-details";
    }
}
