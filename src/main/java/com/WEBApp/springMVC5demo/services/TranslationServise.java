package com.WEBApp.springMVC5demo.services;

import com.WEBApp.springMVC5demo.Entity.Translations;
import com.WEBApp.springMVC5demo.repository.TranslationsRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
@Service
public class TranslationServise {
    private final TranslationsRepository translationsRepository;

    public TranslationServise(TranslationsRepository translationsRepository) {
        this.translationsRepository = translationsRepository;
    }

    public void save(Translations translations){translationsRepository.save(translations);}
}
