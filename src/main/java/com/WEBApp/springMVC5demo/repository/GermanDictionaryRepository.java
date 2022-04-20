package com.WEBApp.springMVC5demo.repository;
import com.WEBApp.springMVC5demo.Entity.GermanDictionary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface GermanDictionaryRepository extends CrudRepository<GermanDictionary, Long> {
    Iterable<GermanDictionary>findByKeyOrValue(String key, String value);
    @Query("select g from GermanDictionary g group by g.id order by g.key")
    Iterable<GermanDictionary>findAllAndOrderByKey();
//    Iterable<GermanDictionary>deleteByKeyOrValue();
}
