package com.WEBApp.springMVC5demo.Controllers;

import com.WEBApp.springMVC5demo.Entity.EnglishDictionary;
import com.WEBApp.springMVC5demo.repository.EnglishDictionaryRepository;
//import com.WEBApp.springMVC5demo.services.EnglishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EnglishDictionaryController {
    @Autowired
    private EnglishDictionaryRepository englishDictionaryRepository;
//    @Autowired
//    private EnglishService englishService;
    @GetMapping("/englishDictionary.html")
    public String getEnglishDictionaryPage(Model model) {
        Iterable<EnglishDictionary> EnglishDictionary = englishDictionaryRepository.findAll();
        model.addAttribute("allEnglishLines", EnglishDictionary);
        model.addAttribute("title", "EnglishDictionsry");
        return "englishDictionary";
    }
    @PostMapping("/englishDictionary.html")
    public String addToDataBase(@RequestParam String key, @RequestParam String value, Model model){
        EnglishDictionary englishDictionary = new EnglishDictionary(key, value);
        englishDictionaryRepository.save(englishDictionary);
        return "englishDictionary";
    }
    @PostMapping("/englishWord.html")
    public String findEnglishValue(@RequestParam String keyword, Model model) {
        Iterable<EnglishDictionary> searchValue = englishDictionaryRepository.findByKeyOrValue(keyword, keyword);
        model.addAttribute("title", "word");
        model.addAttribute("EnglishSearchResult", searchValue);
        return "englishWord";
    }

}
