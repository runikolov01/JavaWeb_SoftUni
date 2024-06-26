package com.paintingscollectors.controller;

import com.paintingscollectors.config.UserSession;
import com.paintingscollectors.model.dto.AddPaintingDTO;
import com.paintingscollectors.service.PaintingService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PaintingController {
    private final UserSession userSession;
    private final PaintingService paintingService;

    public PaintingController(UserSession userSession, PaintingService paintingService) {
        this.userSession = userSession;
        this.paintingService = paintingService;
    }

    @ModelAttribute("paintingData")
    public AddPaintingDTO paintingData() {
        return new AddPaintingDTO();
    }

    @GetMapping("add-painting")
    public String addPainting() {
        if (!userSession.isLoggedIn()) {
            return "redirect:/";
        }

        return "add-painting";
    }

    @PostMapping("/add-painting")
    public String doAddPainting(
            @Valid AddPaintingDTO data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (!userSession.isLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("paintingData", data);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.paintingData", bindingResult);

            return "redirect:/add-painting";
        }

        boolean success = paintingService.create(data);

        if (!success) {
            // show generic error? duplicate name
            redirectAttributes.addFlashAttribute("paintingData", data);

            return "redirect:/add-painting";
        }

        return "redirect:/home";
    }

    @DeleteMapping("/paintings/remove/{id}")
    public String removePainting(@PathVariable Long id) {
        if (!userSession.isLoggedIn()) {
            return "redirect:/";
        }

        paintingService.removeById(id);

        return "redirect:/home";
    }

    @PostMapping("/paintings/add-favorite/{id}")
    public String addFavorite(@PathVariable Long id) {
        Long userId = userSession.getId();
        paintingService.addFavorite(id, userId);
        return "redirect:/home";
    }

    @PostMapping("/paintings/vote/{id}")
    public String voteForPainting(@PathVariable Long id) {
        Long userId = userSession.getId();
        paintingService.voteForPainting(id, userId);
        return "redirect:/home";
    }

    @PostMapping("/paintings/remove-favorite/{id}")
    public String removeFavorite(@PathVariable Long id) {
        Long userId = userSession.getId();
        paintingService.removeFavorite(id, userId);
        return "redirect:/home";
    }


}