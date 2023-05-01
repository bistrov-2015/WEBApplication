package com.WEBApp.springMVC5demo.Controllers;

import com.WEBApp.springMVC5demo.Entity.Languages;
import com.WEBApp.springMVC5demo.Models.LanguageDTO;
import com.WEBApp.springMVC5demo.Models.RequestModelFromSearchForm;
import com.WEBApp.springMVC5demo.Models.ResponseModelForSearchForm;
import com.WEBApp.springMVC5demo.Models.ResponseToGetAllRowFromLanguages;
import com.WEBApp.springMVC5demo.services.DatabaseServiceImplementation;
import com.WEBApp.springMVC5demo.services.LanguagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/serchRequest")
public class SearchController {
    @Autowired
    private LanguagesService languagesService;
    @Autowired
    private DatabaseServiceImplementation databaseServiceImplementation;

    @RequestMapping(value = "/getSearchResulToMainForm", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModelForSearchForm getSearchResulToMainForm(@RequestBody RequestModelFromSearchForm requestModelFromSearchForm) {
        String languageCode1 = requestModelFromSearchForm.getLanguage1();
        String languageCode2 = requestModelFromSearchForm.getLanguage2();
        String wordText = requestModelFromSearchForm.getWordText();
        System.out.println("values from json {" + languageCode1 + "} {" + languageCode2 + "} {" + wordText + "}");
        return new ResponseModelForSearchForm(databaseServiceImplementation
                .findWordTranslationByValueAndLanguageCode(wordText, languageCode1, languageCode2));
    }

    /*@RequestMapping(value = "/getAllRowsFromLanguages", method = RequestMethod.GET)
    @ResponseBody
    public ResponseToGetAllRowFromLanguages getAllRowFromLanguages(){
       // Iterable<Languages> languagesData =  languagesService.findAllAndOderByLanguageCode();
        List<String> languageCodes = languagesService.findAllLanguageCodes();
        List<String> languageNames = languagesService.findAllLanguageNames();
        return new ResponseToGetAllRowFromLanguages(languageCodes, languageNames);
        //return new List<LanguageDTO>listLanguageDTO(LanguageDTO);
        //LanguageDTO класс описывающий все необходимы параметры объекта
    }*/
    @RequestMapping(value = "/getAllRowsFromLanguages", method = RequestMethod.GET)
    @ResponseBody
    public List<LanguageDTO> getAllRowFromLanguages() {
        Iterable<Languages> languagesData = languagesService.findAllAndOderByLanguageCode();
        return convertTOLanguageDTO(languagesData);
        //return new List<LanguageDTO>listLanguageDTO(LanguageDTO);
        //LanguageDTO класс описывающий все необходимы параметры объекта
    }

    public List<LanguageDTO> convertTOLanguageDTO(Iterable<Languages> languagesData) {
        List<LanguageDTO> languageDTOList = new ArrayList<>();

        for (Languages language : languagesData) {
            LanguageDTO languageDTO = new LanguageDTO(
                    language.getLanguageId(),
                    language.getLanguageCode(),
                    language.getLanguageName()
            );
            languageDTOList.add(languageDTO);
        }

        return languageDTOList;
    }

}
