package com.WEBApp.springMVC5demo.services;

import com.WEBApp.springMVC5demo.Entity.Word;
import com.WEBApp.springMVC5demo.repository.WordRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
@Service
public class WordService {
    private final WordRepository wordsRepository;
    public WordService(WordRepository wordsRepository){
        this.wordsRepository = wordsRepository;
    }
    public void save(Word word){wordsRepository.save(word);}

/*    public boolean checkMatchesWithExistingRecordsInDatabase(String word){
        if
    }*/
}
