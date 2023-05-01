package com.WEBApp.springMVC5demo.services;

import com.WEBApp.springMVC5demo.Entity.Languages;
import com.WEBApp.springMVC5demo.repository.LanguageRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class LanguagesService {
    private final LanguageRepository languageRepository;

    public LanguagesService(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }
    /**
     * Method returns all objects from the database.
     * **/
    public Iterable<Languages> findAllAndOderByLanguageCode(){
        return languageRepository.findAllAndOderByLanguageCode();
    }
    /**
     * The method returns a String with the language code for the language "languageName" from the database.
     * **/
    public String findLanguageCodeByLanguageName(String languageName){
        return languageRepository.findLanguageCodeByLanguageName(languageName);
    }
    /**
     * Method save new language object into database.
     * **/
    public void save(Languages languages){
        languageRepository.save(languages);
    }
    /**
     * The method returns all objects with the specified language code from the database.
     * **/
    public String checkLanguageCodeMatches(String languageCode){
        return languageRepository.checkLanguageCodeMatches(languageCode);
    }
    /**
     * The method returns all objects with the specified language name from the database.
     * **/
    public String checkLanguageNameMatches(String languageName){
        return languageRepository.checkLanguageNameMatches(languageName);
    }
    /**
     * The method checks for the existence of records in the database with the specified language code and language name.
     * */
    public boolean checkMatchesWithExistingRecordsInDatabase(String languageCode, String languageName){
        System.out.println("(checkLanguageCodeMatches(languageCode).length() == 0) =================== "
                + (checkLanguageCodeMatches(languageCode) == null));

        if(checkLanguageCodeMatches(languageCode) == null && checkLanguageNameMatches(languageName) == null){
            return true;
        } else return false;
    }

    public List<String> findAllLanguageCodes(){
        return languageRepository.findAllLanguageCodes();
    }

    public List<String> findAllLanguageNames(){
        return languageRepository.findAllLanguageNames();
    }
}
