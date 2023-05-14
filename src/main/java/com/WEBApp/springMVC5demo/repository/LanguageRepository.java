package com.WEBApp.springMVC5demo.repository;

import com.WEBApp.springMVC5demo.Entity.Languages;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LanguageRepository extends CrudRepository<Languages,Long> {
    /*List<Languages>findByLanguageCode(String languageCode);*/
    @Query("select l from Languages l group by l.languageId order by l.languageCode")
    Iterable<Languages> findAllAndOderByLanguageCode();
    /*Stream<Languages> findAllAndOderByLanguageCode();*/
    @Query("select l.languageCode from Languages l")
    List<String> findAllLanguageCodes();

    @Query("select l.languageName from Languages l")
    List<String> findAllLanguageNames();

    @Query("select l.languageCode from Languages l where l.languageName =:languageName")
    String findLanguageCodeByLanguageName(String languageName);

    @Query("select l.languageCode from Languages l where l.languageCode =:languageCode")
    String checkLanguageCodeMatches(String languageCode);

    @Query("select l.languageName from Languages l where l.languageName =:languageName")
    String checkLanguageNameMatches(String languageName);
/*
    @Query("delete from Languages l where l.languageId =:languageId")
    Boolean deleteRowByLanguageId(@Param("languageId") Long languageId);*/

    Iterable<Languages>deleteByLanguageId(long languageId);

    @Query("select l.languageName from Languages l where l.languageId =:languageId")
    String findLanguageNameByLanguageId(@Param("languageId") Long languageId);

    Iterable<Languages>findByLanguageId(long languageId);



}
