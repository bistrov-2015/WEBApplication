package com.WEBApp.springMVC5demo.Controllers;

import com.WEBApp.springMVC5demo.Entity.EnglishDictionary;
import com.WEBApp.springMVC5demo.Entity.GermanDictionary;
import com.WEBApp.springMVC5demo.repository.EnglishDictionaryRepository;
import com.WEBApp.springMVC5demo.repository.GermanDictionaryRepository;
import com.WEBApp.springMVC5demo.services.EnglishService;
import com.WEBApp.springMVC5demo.services.GermanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibraryController {
    @Autowired
    EnglishService englishService;
    @Autowired
    GermanService germanService;
    @PostMapping("/librarySearchResult.html")
    public String findInAllDictionarys(@RequestParam String keyword, Model model){
        Iterable<GermanDictionary> searchValueGerm = germanService.findByKeyOrValue(keyword, keyword);
        model.addAttribute("GermanSearchResult", searchValueGerm);
        Iterable<EnglishDictionary> searchValueEn = englishService.findByKeyOrValue(keyword, keyword);
        model.addAttribute("EnglishSearchResult", searchValueEn);
        model.addAttribute("title", "result");
        return "librarySearchResult";
    }
}
