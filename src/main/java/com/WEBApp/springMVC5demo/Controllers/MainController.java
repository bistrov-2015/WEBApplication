package com.WEBApp.springMVC5demo.Controllers;

import com.WEBApp.springMVC5demo.Entity.*;
import com.WEBApp.springMVC5demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    EnglishService englishService;
    @Autowired
//    private GermanDictionaryRepository germanDictionaryRepository;
    GermanService germanService;
    @Autowired
    LanguagesService languagesService;
    @Autowired
    DatabaseServiceImplementation databaseServiceImplementation;
    @Autowired
    WordService wordService;
    @Autowired
    TranslationServise translationServise;

    public void createTempEntity(){
        Languages languagesEng = new Languages("eng", "English");
        languagesService.save(languagesEng);
        Languages languagesRus = new Languages("rus", "Русский");
        languagesService.save(languagesRus);

        Word word1 = new Word( "cat", languagesEng);
        wordService.save(word1);
        Word word2 = new Word("кот", languagesRus);
        wordService.save(word2
        );
        Translations translations1 = new Translations(word1.getWordId(), word2.getWordId());
        translationServise.save(translations1);
    }




    @GetMapping("/")
    public String getHomePage(Model model) {
        createTempEntity();
        Iterable<Languages> Languages = languagesService.findAllAndOderByLanguageCode();
        model.addAttribute("Languages",Languages);
        /*model.addAttribute("title", "editorialOffice");*/
        return "editorialOffice";
    }
   /* @PostMapping("/serchResult")
    public String returnSearchResult(@RequestParam String language1, String language2, String wordText){
        String languageCode1 = languagesService.findLanguageCodeByLanguageValue(language1);
        String languageCode2 = languagesService.findLanguageCodeByLanguageValue(language2);

        return languageCode1;//databaseServiceImplementation.findWordTranslationByValueAndLanguageCode(wordText,languageCode1,languageCode2);
    }*/
    @GetMapping("/home.html")
    public String returnToHomePage(Model model) {
        model.addAttribute("title", "Dictionary's");
        return "home";
    }
    @GetMapping("/editorialOffice.html")
    public String editorialOfficePage(Model model) {

       model.addAttribute("title", "editorialOffice");
       Iterable<Languages> Languages = languagesService.findAllAndOderByLanguageCode();
       model.addAttribute("allLanguagesCods",Languages);
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
