package com.WEBApp.springMVC5demo.Models;

public class ResponseAddNewLanguage {
    private String infoMessageAboutAddNewLanguageResult;

    public String getInfoMessageAboutAddNewLanguageResult() {
        return infoMessageAboutAddNewLanguageResult;
    }

    public void setInfoMessageAboutAddNewLanguageResult(String infoMessageAboutAddNewLanguageResult) {
        this.infoMessageAboutAddNewLanguageResult = infoMessageAboutAddNewLanguageResult;
    }

    public ResponseAddNewLanguage(String infoMessageAboutAddNewLanguageResult) {
        this.infoMessageAboutAddNewLanguageResult = infoMessageAboutAddNewLanguageResult;
    }
}
