package com.WEBApp.springMVC5demo.repository;
import com.WEBApp.springMVC5demo.Entity.GermanDictionary;
import org.springframework.data.repository.CrudRepository;


public interface GermanDictionaryDatatbaseInterface extends CrudRepository<GermanDictionary, Integer> {
//    Iterable<GermanDictionary> findAll (); есть в JPA Reposinory
    Iterable<GermanDictionary> findByKey();
    Iterable<GermanDictionary> findByValue();
//    Iterable

}
