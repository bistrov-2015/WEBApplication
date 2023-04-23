package com.WEBApp.springMVC5demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "WORD")
public class Word {
    @Id
    @Column(name = "WORD_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long wordId;

    /*@Column(name = "LANGUAGE_CODE")
    private String languageCode;*/

    @Column(name = "WORD_VALUE")
    private String value;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "translationId")
    private List<Translations> translations;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "languageCode", nullable = false)
    private Languages languageCodeReference;

   /* public Word(String eng, String cat, int i, int i1) {
    }*/

    /*public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }*/


    public void setValue(String value) {
        this.value = value;
    }

   /* public void setTranslations(Translations translations) {
        this.translations = (List<Translations>) translations;
    }*/

    public void setLanguageCodeReference(Languages languageCodeReference) {
        this.languageCodeReference = languageCodeReference;
    }

    public Long getWordId() {
        return wordId;
    }

   /* public String getLanguageCode() {
        return languageCode;
    }*/

    public String getValue() {
        return value;
    }

   /* public List<Translations> getTranslations() {
        return translations;
    }*/

    public Languages getLanguageCodeReference() {
        return languageCodeReference;
    }
    /* public Long getWordId() {
        return wordId;
    }

    public Languages getLanguageCode() {
        return languageCodeReference;
    }

    public void setLanguageCode(Languages value) {
        this.languageCodeReference = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }*/

    protected Word() {
    }

    public Word(/*String languageCode,*/ String value,/* Translations translations,*/ Languages languageCodeReference ) {
        //this.languageCode = languageCode;
        this.value = value;
        //this.translations = (List<Translations>) translations;
        this.languageCodeReference = languageCodeReference;
    }

}
