package com.WEBApp.springMVC5demo.Controllers;

import com.WEBApp.springMVC5demo.Enums.MessegesForUser;
import com.WEBApp.springMVC5demo.Models.LanguageDTO;
import com.WEBApp.springMVC5demo.Models.Message;
import com.WEBApp.springMVC5demo.services.LanguagesService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/updateRow", method = RequestMethod.PUT)
public class UpdateController {
    private final LanguagesService languagesService;

    public UpdateController(LanguagesService languagesService) {
        this.languagesService = languagesService;
    }

    @RequestMapping(value = "/updateLanguage", method = RequestMethod.PUT)
    @ResponseBody
    public Message updateRowInLanguageTable(@RequestBody @NotNull LanguageDTO languageDTO){
        languagesService.updateLanguage(languageDTO);
        return new Message(MessegesForUser.UPDATE_DONE.getMessege());
    }
}
