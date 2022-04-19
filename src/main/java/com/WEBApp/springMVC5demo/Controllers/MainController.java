package com.WEBApp.springMVC5demo.Controllers;

import com.WEBApp.springMVC5demo.Entity.EnglishDictionary;
import com.WEBApp.springMVC5demo.Entity.GermanDictionary;
import com.WEBApp.springMVC5demo.repository.EnglishDictionaryRepository;
import com.WEBApp.springMVC5demo.repository.GermanDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private EnglishDictionaryRepository englishDictionaryRepository;
    @Autowired
    private GermanDictionaryRepository germanDictionaryRepository;
    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("title", "Dictionary's");
        return "home";
    }
    @GetMapping("/home.html")
    public String returnToHomePage(Model model) {
        model.addAttribute("title", "Dictionary's");
        return "home";
    }
    @GetMapping("/editorialOffice.html")
    public String editorialOfficePage(Model model) {
       model.addAttribute("title", "editorialOffice");
        return "editorialOffice";
    }
    @GetMapping("/library.html")
    public String getLibraryPage(Model model) {
        Iterable<EnglishDictionary> EnglishDictionsry = englishDictionaryRepository.findAllAndOrderByKey();//findAllAndGroupByKeyValueOrderByKey();//
        Iterable<GermanDictionary> GermanDictionary = germanDictionaryRepository.findAllAndOrderByKey();//findAll();
        model.addAttribute("allEnglishLines", EnglishDictionsry);
        model.addAttribute("allGermanLines", GermanDictionary);
        model.addAttribute("title", "library");
        return "library";
    }
}
