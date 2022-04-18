/*package com.WEBApp.springMVC5demo.services;

import com.WEBApp.springMVC5demo.Entity.EnglishDictionary;
import com.WEBApp.springMVC5demo.repository.EnglishDictionaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnglishService {
    private final EnglishDictionaryRepository englishDictionaryRepository;

    public EnglishService(EnglishDictionaryRepository englishDictionaryRepository) {
        this.englishDictionaryRepository = englishDictionaryRepository;
    }
    public List<EnglishDictionary> findEnglishWord(String keyword){
        return englishDictionaryRepository.searchEnglishDictionariesWord(keyword);
    }
}*/
