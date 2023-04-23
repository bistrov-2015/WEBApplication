package com.WEBApp.springMVC5demo.repository;

import com.WEBApp.springMVC5demo.Entity.Translations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TranslationsRepository extends JpaRepository<Translations, Long> {
    //@Query("select word2Referense from Translations t where word1Reference = wordId")
    Translations findTranslationsByWord1Id(Long word1Id);
    /*Translations findTranslationsByWord1Id(Long wordId);
    List<Long> findTranslationsWord2IdByWord1Id(Long wordId);*/
    @Query(value = "select t.word2Id from Translations t where t.word1Id = :word1Id")
    List<Long> findWord2IdByWord1Id(Long word1Id);

    @Query(value = "select t.word1Id from Translations t where t.word2Id = :word2Id")
    List<Long> findWord1IdByWord2Id(Long word2Id);
    /*
    * findWord1IdByWord2Id обратный запрос */
}
