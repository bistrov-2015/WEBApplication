package com.WEBApp.springMVC5demo.services;

import com.WEBApp.springMVC5demo.repository.LanguageRepository;
import com.WEBApp.springMVC5demo.repository.TranslationsRepository;
import com.WEBApp.springMVC5demo.repository.WordRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseServiceImplementation implements DatabaseService {
    //private final ApplicationRepository applicationRepository;
    private final LanguageRepository languageRepository;
    private final TranslationsRepository translationsRepository;
    private final WordRepository wordsRepository;
    /*ApplicationRepository applicationRepository*/
    public DatabaseServiceImplementation(LanguageRepository languageRepository, TranslationsRepository translationsRepository,
                                         WordRepository wordsRepository){
       // this.applicationRepository = applicationRepository;
        this.languageRepository = languageRepository;
        this.translationsRepository = translationsRepository;
        this.wordsRepository = wordsRepository;
    }

    /**
     * @param value текст слова которое нужно перевести;
     * @param word1LanguageCode код языка слова, которое нужно перевести;
     * @param word2LanguageCode код языка, на который нужно перевести;
     * @return Текст слова которое является переводом на указанный язык;
     */

    public List<String> findWordTranslationByValueAndLanguageCode(String value, String word1LanguageCode, String word2LanguageCode){
        Long wordId = wordsRepository.findWordIdByLanguageCodeAndValue(word1LanguageCode, value);
        List<Long> word2IdTemp = translationsRepository.findWord2IdByWord1Id(wordId);
        List<Long> word1IdTemp = translationsRepository.findWord1IdByWord2Id(wordId);
        word2IdTemp.addAll(word1IdTemp);
        return wordsRepository.findWord2ValueByWord2IdAndLanguageCode(word2IdTemp, word2LanguageCode) ;
    }




}
