package com.WEBApp.springMVC5demo.services;

import com.WEBApp.springMVC5demo.Entity.GermanDictionary;
import com.WEBApp.springMVC5demo.repository.GermanDictionaryRepository;
import org.springframework.stereotype.Service;

@Service
public class GermanService {
    private final GermanDictionaryRepository germanDictionaryRepository;
    public GermanService(GermanDictionaryRepository germanDictionaryRepository) {
        this.germanDictionaryRepository = germanDictionaryRepository;
    }
    public Iterable<GermanDictionary> findByKeyOrValue(String key, String value){
        return germanDictionaryRepository.findByKeyOrValue(key, value);
    }
    public Iterable<GermanDictionary>findAllAndOrderByKey(){
        return germanDictionaryRepository.findAllAndOrderByKey();
    }
//    public Iterable<GermanService>save(){
//        return germanDictionaryRepository.save();
//    }

    public void save(GermanDictionary germanDictionary) {
        germanDictionaryRepository.save(germanDictionary);
    }
}
