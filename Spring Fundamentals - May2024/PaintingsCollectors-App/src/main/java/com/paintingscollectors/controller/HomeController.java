package com.paintingscollectors.controller;

import com.paintingscollectors.config.UserSession;
import com.paintingscollectors.model.dto.PaintingInfoDTO;
import com.paintingscollectors.model.entity.Painting;
import com.paintingscollectors.service.PaintingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final PaintingService paintingService;
    private final UserSession userSession;


    public HomeController(PaintingService paintingService, UserSession userSession) {
        this.paintingService = paintingService;
        this.userSession = userSession;
    }

    @GetMapping("/")
    private String nonLoggedInHomePage() {
        return "index";
    }

    @GetMapping("/home")
    @Transactional
    public String loggedInIndex(Model model) {
        if (!userSession.isLoggedIn()) {
            return "redirect:/";
        }

        Long userId = userSession.getId();

        List<Painting> userPaintings = paintingService.findAllPaintingsForOneUser(userId);

        List<PaintingInfoDTO> myPaintings = userPaintings.stream()
                .map(PaintingInfoDTO::new)
                .collect(Collectors.toList());

        List<Painting> otherUsersPaintings = paintingService.findAllPaintingsExceptUser(userId);
        Set<Painting> myFavorites = paintingService.findUserFavoritePaintings(userId);
        List<Painting> mostRatedPaintings = paintingService.findMostRatedPaintings();

        model.addAttribute("myPaintings", myPaintings);
        model.addAttribute("myFavorites", myFavorites);
        model.addAttribute("otherUsersPaintings", otherUsersPaintings);
        model.addAttribute("mostRatedPaintings", mostRatedPaintings);

        return "home";
    }
}