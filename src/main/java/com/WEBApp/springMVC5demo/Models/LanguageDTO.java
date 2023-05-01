package com.WEBApp.springMVC5demo.Models;

public class LanguageDTO {
    private long languageId;
    private String languageCode;
    private String languageName;

    public LanguageDTO() {
    }

    public LanguageDTO(long languageId, String languageCode, String languageName) {
        this.languageId = languageId;
        this.languageCode = languageCode;
        this.languageName = languageName;
    }

    public long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(long languageId) {
        this.languageId = languageId;
    }

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
