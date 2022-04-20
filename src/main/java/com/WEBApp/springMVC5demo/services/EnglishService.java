package com.WEBApp.springMVC5demo.services;

import com.WEBApp.springMVC5demo.Entity.EnglishDictionary;
import com.WEBApp.springMVC5demo.Entity.GermanDictionary;
import com.WEBApp.springMVC5demo.repository.EnglishDictionaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnglishService {
    private final EnglishDictionaryRepository englishDictionaryRepository;

    public EnglishService(EnglishDictionaryRepository englishDictionaryRepository) {
        this.englishDictionaryRepository = englishDictionaryRepository;
    }
    public Iterable<EnglishDictionary> findByKeyOrValue(String key, String value){
        return englishDictionaryRepository.findByKeyOrValue(key, value);
    }
    public Iterable<EnglishDictionary>findAllAndOrderByKey(){
        return englishDictionaryRepository.findAllAndOrderByKey();
    }
    public void save(EnglishDictionary englishDictionary){
        englishDictionaryRepository.save(englishDictionary);
    }
}
