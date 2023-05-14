package com.WEBApp.springMVC5demo.Models;

public class LanguageIdDTO {
    private Long languageId;

    public LanguageIdDTO() {
    }

    public LanguageIdDTO(Long languageId) {
        this.languageId = languageId;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }
}
