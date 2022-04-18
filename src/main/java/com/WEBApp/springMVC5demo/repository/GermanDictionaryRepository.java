package com.WEBApp.springMVC5demo.repository;
import com.WEBApp.springMVC5demo.Entity.GermanDictionary;
import org.springframework.data.repository.CrudRepository;


public interface GermanDictionaryRepository extends CrudRepository<GermanDictionary, Long> {
    Iterable<GermanDictionary>findByKeyOrValue(String key, String val);
}
