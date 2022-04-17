package com.WEBApp.springMVC5demo.Controllers;

import com.WEBApp.springMVC5demo.Entity.GermanDictionary;
import com.WEBApp.springMVC5demo.repository.GermanDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GermanDictionaryController {
    @Autowired
    private GermanDictionaryRepository germanDictionaryRepository;
    @GetMapping("/germanDictionary.html")
    public String getGermanDictionaryPage(Model model){
        Iterable<GermanDictionary> GermanDictionary = germanDictionaryRepository.findAll();
        model.addAttribute("allGermanLines", GermanDictionary);
        model.addAttribute("title", "GermanDictionary");
        return("germanDictionary");
    }
}
