package bg.softuni.Pathfinder.web;

import bg.softuni.Pathfinder.model.dto.RouteShortInfoDTO;
import bg.softuni.Pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {
    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String openRoutesPage(Model model) {
        RouteShortInfoDTO randomRoute = routeService.getRandomRoute();
        model.addAttribute("route", randomRoute);

        return "routes";
    }
}