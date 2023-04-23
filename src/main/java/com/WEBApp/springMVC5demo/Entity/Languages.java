package com.WEBApp.springMVC5demo.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LANGUAGE")
public class
Languages {
    @Id
    @Column(name = "LANGUAGE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long languageId;

    @Column(name = "LANGUAGE_CODE")
    private String languageCode;

    @Column(name = "LANGUAGE_NAME")
    private String languageName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "languageCodeReference")
    private List<Word> words; // хранит список слов принадлежащих к коду языка

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public String getLanguageName() {
        return languageName;
    }

    public List<Word> getWords() {
        return words;
    }

    protected Languages() {
    }

    public Languages(String language_code, String languageName) {
        this.languageCode = language_code;
        this.languageName = languageName;
    }


}
