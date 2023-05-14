package com.WEBApp.springMVC5demo.Controllers;

import com.WEBApp.springMVC5demo.Enums.MessegesForUser;
import com.WEBApp.springMVC5demo.Models.LanguageIdDTO;
import com.WEBApp.springMVC5demo.Models.Message;
import com.WEBApp.springMVC5demo.services.LanguagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deleteRow")
public class DeleteController {
    @Autowired
    private LanguagesService languagesService;

    private MessegesForUser messegesForUser;

    public void setMessegesForUser(MessegesForUser messegesForUser) {
        this.messegesForUser = messegesForUser;
    }

    public DeleteController(LanguagesService languagesService) {
        this.languagesService = languagesService;

    }


    @RequestMapping(value = "/deleteLanguage", method = RequestMethod.POST)
    @ResponseBody
    public Message deleteLanguage(@RequestBody LanguageIdDTO languageIdDTO) {
        languagesService.safeDeleteFromLanguages(languageIdDTO.getLanguageId());
        return new Message(messegesForUser.DELETE_SUCCES.getMessege());
        /*if (languagesService.safeDeleteFromLanguages(languageIdDTO.getLanguageId())) {
            return new Message(messegesForUser.DELETE_SUCCES.getMessege());
        } else {
            return new Message(messegesForUser.DELETE_FAIL.getMessege());*/
        }


}

