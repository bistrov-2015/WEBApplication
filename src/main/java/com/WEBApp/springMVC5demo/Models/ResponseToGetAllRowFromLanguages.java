package com.WEBApp.springMVC5demo.Models;

import java.util.List;

public class ResponseToGetAllRowFromLanguages {
    private List<String> languageCode;
    private List<String> languageName;

    public ResponseToGetAllRowFromLanguages(List<String> languageCode, List<String> languageName) {
        this.languageCode = languageCode;
        this.languageName = languageName;
    }

    public List<String> getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(List<String> languageCode) {
        this.languageCode = languageCode;
    }

    public List<String> getLanguageName() {
        return languageName;
    }

    public void setLanguageName(List<String> languageName) {
        this.languageName = languageName;
    }
}
