/**
 * Long findWordIdByLanguageCodeAndValue - метод принимает два параметра: код языка того слова, которое нужно перевести и значение слова(текст)
 * возвращает Id этого слова.
 *
 * String findWord2ValueByWord2IdAndLanguageCode(List<Long> word2Id, String languageCode) - метод принимает два параметра: список слов, котрые
 * являются переводами для искомого слова и код языка, на который нужно сделать перевод.
 *
 * * */
package com.WEBApp.springMVC5demo.repository;

import com.WEBApp.springMVC5demo.Entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {
   /* Word findWordIdByLanguageCodeAndValue(String languageCode, String value);
    Word findByWordId(Word wordId);*/

    @Query("select w.wordId from Word w where w.languageCodeReference.languageCode = :languageCode and w.value = :value")
    Long findWordIdByLanguageCodeAndValue (String languageCode, String value);

    @Query("select w.value from Word w where w.wordId  in :word2Id and w.languageCodeReference.languageCode = :languageCode")
    List<String> findWord2ValueByWord2IdAndLanguageCode(List<Long> word2Id, String languageCode);
    /**Есть мысль что второй параметр д.быть не строкой а объектом language*/
    //Iterable<Word>findAllByValueAnAndLanguageCodeReference(String word, String languageCode);


}
