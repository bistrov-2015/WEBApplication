package com.WEBApp.springMVC5demo.repository;

import com.WEBApp.springMVC5demo.Entity.Languages;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface LanguageRepository extends CrudRepository<Languages,Long> {
    /*List<Languages>findByLanguageCode(String languageCode);*/
    @Query("select l from Languages l group by l.languageId order by l.languageCode")
    Iterable<Languages>findAllAndOderByLanguageCode();
    @Query("select l.languageCode from Languages l where l.languageName =:languageValue")
    String findLanguageCodeByLanguageValue(String languageValue);
}
