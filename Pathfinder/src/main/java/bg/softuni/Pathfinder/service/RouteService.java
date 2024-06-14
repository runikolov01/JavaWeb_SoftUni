package bg.softuni.Pathfinder.service;

import bg.softuni.Pathfinder.model.dto.RouteShortInfoDTO;
import org.springframework.stereotype.Service;

@Service
public interface RouteService {
    RouteShortInfoDTO getRandomRoute();
}