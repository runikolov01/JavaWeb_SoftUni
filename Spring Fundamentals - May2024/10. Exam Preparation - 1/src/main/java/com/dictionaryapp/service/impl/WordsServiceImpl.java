package com.dictionaryapp.service.impl;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.entity.AddWordDTO;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.WordsService;
import org.springframework.stereotype.Service;

@Service
public class WordsServiceImpl implements WordsService {
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private final UserSession userSession;

    public WordsServiceImpl(LanguageRepository languageRepository, UserRepository userRepository, UserSession userSession) {
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public void add(AddWordDTO data) {
        Word word = new Word();

        // TODO: Save and attach correct user + language
    }
}