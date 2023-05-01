package com.WEBApp.springMVC5demo.Models;

public class RequestAddNewWord {
    private String wordLanguageCode;
    private String wordTranslationLanguageCode;
    private String newWord;
    private String wordTranslation;

    public RequestAddNewWord(String wordLanguageCode, String wordTranslationLanguageCode, String newWord, String wordTranslation) {
        this.wordLanguageCode = wordLanguageCode;
        this.wordTranslationLanguageCode = wordTranslationLanguageCode;
        this.newWord = newWord;
        this.wordTranslation = wordTranslation;
    }

    public String getWordLanguageCode() {
        return wordLanguageCode;
    }

    public void setWordLanguageCode(String wordLanguageCode) {
        this.wordLanguageCode = wordLanguageCode;
    }

    public String getWordTranslationLanguageCode() {
        return wordTranslationLanguageCode;
    }

    public void setWordTranslationLanguageCode(String wordTranslationLanguageCode) {
        this.wordTranslationLanguageCode = wordTranslationLanguageCode;
    }

    public String getNewWord() {
        return newWord;
    }

    public void setNewWord(String newWord) {
        this.newWord = newWord;
    }

    public String getWordTranslation() {
        return wordTranslation;
    }

    public void setWordTranslation(String wordTranslation) {
        this.wordTranslation = wordTranslation;
    }
}
