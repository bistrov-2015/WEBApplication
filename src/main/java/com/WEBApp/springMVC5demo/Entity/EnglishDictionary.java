package com.WEBApp.springMVC5demo.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "EnglishLanguageDictionary")

public class EnglishDictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String key;
    @Column
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public EnglishDictionary() {
    }

    public EnglishDictionary(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
