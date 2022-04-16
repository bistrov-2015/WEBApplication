package com.WEBApp.springMVC5demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "GermanLanguageDictionary")
public class GermanDictionary {
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
}
