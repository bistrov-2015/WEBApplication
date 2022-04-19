package com.WEBApp.springMVC5demo.repository;

import com.WEBApp.springMVC5demo.Entity.EnglishDictionary;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface EnglishDictionaryRepository extends CrudRepository<EnglishDictionary, Long > {
    Iterable<EnglishDictionary> findByKeyOrValue(String key, String value);
    @Query("select e from EnglishDictionary e group by e.id order by e.key")
    Iterable<EnglishDictionary>findAllAndOrderByKey();
//    @Query("select e.key, e.value from EnglishDictionary e group by e.key, e.value order by e.key")
//    Iterable<EnglishDictionary>findAllAndGroupByKeyValueOrderByKey();
    }
