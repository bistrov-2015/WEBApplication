package com.WEBApp.springMVC5demo.Controllers;

import com.WEBApp.springMVC5demo.Models.RequestModelFromSearchForm;
import com.WEBApp.springMVC5demo.Models.ResponseModelForSearchForm;
import com.WEBApp.springMVC5demo.services.DatabaseServiceImplementation;
import com.WEBApp.springMVC5demo.services.LanguagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping(value = "/serchRequestFromMainForm")
public class SearchController {
    @Autowired
    private LanguagesService languagesService;
    @Autowired
    private DatabaseServiceImplementation databaseServiceImplementation;
    @RequestMapping(value = "/getSearchResulToMainForm", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModelForSearchForm getSearchResulToMainForm(@RequestBody RequestModelFromSearchForm requestModelFromSearchForm){
        String languageCode1 = requestModelFromSearchForm.getLanguage1();
        String languageCode2 = requestModelFromSearchForm.getLanguage2();
        String wordText = requestModelFromSearchForm.getWordText();
        System.out.println("values from json {"+languageCode1 +"} {" + languageCode2 + "} {" + wordText + "}");
        return new ResponseModelForSearchForm(databaseServiceImplementation
                .findWordTranslationByValueAndLanguageCode(wordText,languageCode1,languageCode2));
    }

}
