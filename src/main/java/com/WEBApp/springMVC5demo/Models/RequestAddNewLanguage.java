package com.WEBApp.springMVC5demo.Models;

public class RequestAddNewLanguage {
    private String languageCode;
    private String languageName;

    public RequestAddNewLanguage(String languageCode, String languageName) {
        this.languageCode = languageCode;
        this.languageName = languageName;
    }

    public RequestAddNewLanguage() {}

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }
}
