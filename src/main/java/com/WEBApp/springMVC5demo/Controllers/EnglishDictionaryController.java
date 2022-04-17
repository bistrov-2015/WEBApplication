package com.WEBApp.springMVC5demo.Controllers;

import com.WEBApp.springMVC5demo.Entity.EnglishDictionary;
import com.WEBApp.springMVC5demo.Entity.GermanDictionary;
import com.WEBApp.springMVC5demo.repository.EnglishDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnglishDictionaryController {
    @Autowired
    private EnglishDictionaryRepository englishDictionaryRepository;
    @GetMapping("/englishDictionary.html")
    public String getEnglishDictionaryPage(Model model) {
        Iterable<EnglishDictionary> EnglishDictionsry = englishDictionaryRepository.findAll();
        model.addAttribute("allEnglishLines", EnglishDictionsry);
        model.addAttribute("title", "EnglishDictionsry");
        return "englishDictionary";
    }

}
