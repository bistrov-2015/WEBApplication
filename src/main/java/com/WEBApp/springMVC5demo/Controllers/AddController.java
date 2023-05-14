package com.WEBApp.springMVC5demo.Controllers;

import com.WEBApp.springMVC5demo.Entity.Languages;
import com.WEBApp.springMVC5demo.Enums.MessegesForUser;
import com.WEBApp.springMVC5demo.Models.RequestAddNewLanguage;
import com.WEBApp.springMVC5demo.Models.RequestAddNewWord;
import com.WEBApp.springMVC5demo.Models.ResponseAddNewLanguage;
import com.WEBApp.springMVC5demo.Models.ResponseAddNewWord;
import com.WEBApp.springMVC5demo.services.LanguagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/addToDictionary")

public class AddController {

    @Autowired
    private LanguagesService languagesService;

    private MessegesForUser messegesForUser;

    public void setMessegesForUser(MessegesForUser messegesForUser) {
        this.messegesForUser = messegesForUser;
    }

    public AddController(LanguagesService languagesService) {
                this.languagesService = languagesService;
    }


    @RequestMapping(value = "/addNewLanguage", method = RequestMethod.POST)
    @ResponseBody
    public ResponseAddNewLanguage addNewLanguage(@RequestBody RequestAddNewLanguage requestAddNewLanguage) {
        String languageCode = requestAddNewLanguage.getLanguageCode();
        String languageName = requestAddNewLanguage.getLanguageName();
        System.out.println("languageCode ------------------ "+ languageCode);
        System.out.println("languageName ------------------ "+ languageName);
        System.out.println("checkMatchesWithExistingRecordsInDatabase -------------------" + languagesService.checkMatchesWithExistingRecordsInDatabase(languageCode, languageName));
        if(languagesService.checkMatchesWithExistingRecordsInDatabase(languageCode, languageName)){
            languagesService.save(new Languages(languageCode, languageName));
            return new ResponseAddNewLanguage(messegesForUser.NEW_LANGUAGE_ADDED_SUCCESFULLY.getMessege());
        }else return new ResponseAddNewLanguage(messegesForUser.NEW_LANGUAGE_ADDED_FAILURE.getMessege());

        /**
         *Нужен boolean метод, который определяет есть ли совпадения в БД и по коду и имени языка
         *  **/
    }



    /*@RequestMapping(value = "/addNewWord", method = RequestMethod.POST)
    @ResponseBody
    public ResponseAddNewWord addNewWordInDictionary(@RequestBody RequestAddNewWord requestAddNewWord){
        String wordLanguageCode = requestAddNewWord.getWordLanguageCode();
        String wordTranslationLanguageCode = requestAddNewWord.getWordTranslationLanguageCode();
        String newWord = requestAddNewWord.getNewWord();
        String wordTranslation = requestAddNewWord.getWordTranslation();


    }*/
}
