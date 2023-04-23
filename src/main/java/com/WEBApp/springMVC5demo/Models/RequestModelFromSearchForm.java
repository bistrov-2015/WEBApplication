package com.WEBApp.springMVC5demo.Models;

public class RequestModelFromSearchForm {
    private String language1;
    private String language2;
    private String wordText;

    public RequestModelFromSearchForm(String language1, String language2, String wordText) {
        this.language1 = language1;
        this.language2 = language2;
        this.wordText = wordText;
    }

    public RequestModelFromSearchForm() {

    }

    public String getLanguage1() {
        return language1;
    }

    public String getLanguage2() {
        return language2;
    }

    public String getWordText() {
        return wordText;
    }

    public void setLanguage1(String language1) {
        this.language1 = language1;
    }

    public void setLanguage2(String language2) {
        this.language2 = language2;
    }

    public void setWordText(String wordText) {
        this.wordText = wordText;
    }
}
