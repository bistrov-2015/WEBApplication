package com.WEBApp.springMVC5demo.services;

import com.WEBApp.springMVC5demo.Entity.EnglishDictionary;
import com.WEBApp.springMVC5demo.Entity.Languages;
import com.WEBApp.springMVC5demo.repository.LanguageRepository;
import org.springframework.stereotype.Service;

@Service
public class LanguagesService {
    private final LanguageRepository languageRepository;
    public LanguagesService(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }
    public Iterable<Languages> findAllAndOderByLanguageCode(){
        return languageRepository.findAllAndOderByLanguageCode();
    }
    public String findLanguageCodeByLanguageValue(String languageValue){
        return languageRepository.findLanguageCodeByLanguageValue(languageValue);
    }
    public void save(Languages languages){
        languageRepository.save(languages);
    }

}
