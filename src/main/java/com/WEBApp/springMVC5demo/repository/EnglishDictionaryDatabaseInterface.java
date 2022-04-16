package com.WEBApp.springMVC5demo.repository;

import com.WEBApp.springMVC5demo.Entity.EnglishDictionary;
import org.springframework.data.repository.CrudRepository;

public interface EnglishDictionaryDatabaseInterface extends CrudRepository<EnglishDictionary, Integer > {
}
