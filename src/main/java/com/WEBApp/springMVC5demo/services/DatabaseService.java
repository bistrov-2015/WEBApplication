package com.WEBApp.springMVC5demo.services;

import java.util.List;

public interface DatabaseService {
    List<String> findWordTranslationByValueAndLanguageCode(String value, String word1LanguageCode, String word2LanguageCode);
    /*Long findWordIdByLanguageCodeAndValue(String languageCode, String value);
    Long findByWordId(Word wordId);
    Long getTranslationWordIdByWordId(Long wordId);
    @Query("")
    List<Word>getTranslation(Long wordId);*/
}
