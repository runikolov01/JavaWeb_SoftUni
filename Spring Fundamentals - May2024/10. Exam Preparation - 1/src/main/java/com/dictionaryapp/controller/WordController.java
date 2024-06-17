package com.dictionaryapp.controller;

import com.dictionaryapp.model.entity.AddWordDTO;
import com.dictionaryapp.service.impl.WordsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WordController {

    private WordsServiceImpl wordsService;

    public WordController(WordsServiceImpl wordsService) {
        this.wordsService = wordsService;
    }

    @GetMapping("/words")
    public String viewAddWord() {
        return "word-add";
    }

    @PostMapping("/words")
    public String doAddWord(
            @Valid AddWordDTO data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addWordData", data);
            redirectAttributes.addAttribute(
                    "org.springframework.validation.BindingResult.addWordData", bindingResult);

            return "redirect:/words";
        }

        wordsService.add(data);

        return "redirect:/home";
    }
}