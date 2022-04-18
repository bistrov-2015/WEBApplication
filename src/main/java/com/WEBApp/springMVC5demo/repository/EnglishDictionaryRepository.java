package com.WEBApp.springMVC5demo.repository;

import com.WEBApp.springMVC5demo.Entity.EnglishDictionary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnglishDictionaryRepository extends CrudRepository<EnglishDictionary, Long > {
//    List<EnglishDictionary> findEnglishWord(String key, String value);
   /* @Query(value = "SELECT e FROM EnglishDictionary e WHERE e.key LIKE '%' || :keyword || '%'"
            + " OR e.value LIKE '%' || :keyword || '%'")*/
    Iterable<EnglishDictionary> findByKeyOrValue(String key, String value);
    }
//@Query(value = "SELECT id FROM EnglishDictionary  WHERE key LIKE :keyword "
//        + " OR value LIKE  :keyword ")