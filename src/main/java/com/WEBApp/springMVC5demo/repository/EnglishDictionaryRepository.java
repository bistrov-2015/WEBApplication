package com.WEBApp.springMVC5demo.repository;

import com.WEBApp.springMVC5demo.Entity.EnglishDictionary;
import org.springframework.data.repository.CrudRepository;

public interface EnglishDictionaryRepository extends CrudRepository<EnglishDictionary, Long > {
}
