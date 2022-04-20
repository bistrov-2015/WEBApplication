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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    EnglishService englishService;
    @Autowired
//    private GermanDictionaryRepository germanDictionaryRepository;
    GermanService germanService;
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
        Iterable<EnglishDictionary> EnglishDictionsry = englishService.findAllAndOrderByKey();//findAllAndGroupByKeyValueOrderByKey();//
        Iterable<GermanDictionary> GermanDictionary = germanService.findAllAndOrderByKey();//findAll();
        model.addAttribute("allEnglishLines", EnglishDictionsry);
        model.addAttribute("allGermanLines", GermanDictionary);
        model.addAttribute("title", "library");
        return "library";
    }
}
