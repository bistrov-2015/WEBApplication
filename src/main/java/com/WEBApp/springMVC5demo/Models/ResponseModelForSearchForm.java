package com.WEBApp.springMVC5demo.Models;

import java.util.List;

public class ResponseModelForSearchForm {
    private List<String> translationText;

    public ResponseModelForSearchForm(List<String> translationText) {
        this.translationText = translationText;
    }

    public List<String> getTranslationText() {
        return translationText;
    }

    public void setTranslationText(List<String> translationText) {
        this.translationText = translationText;
    }
}
