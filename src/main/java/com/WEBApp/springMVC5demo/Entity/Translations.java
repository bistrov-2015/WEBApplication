package com.WEBApp.springMVC5demo.Entity;

import javax.persistence.*;


@Entity
@Table(name = "TRANSLATION")
public class Translations {
    @Id
    @Column(name = "TRANSLATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long translationId;

    @Column(name = "WORD_1_ID")
    private Long word1Id;

    @Column(name = "WORD_2_ID")
    private Long word2Id;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wordId")
    private Word words;*/

    /*@OneToOne(fetch = FetchType.LAZY, mappedBy = "wordId")
    private Word word1;

    //@Column(name = "TRANSLATION_WORD_2_ID")
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "wordId")
    //@JoinColumn(name = "wordId")
    private Word word2;*/
    public void setWord1Id(Long word1Id) {
        this.word1Id = word1Id;
    }

    public void setWord2Id(Long word2Id) {
        this.word2Id = word2Id;
    }

    /*public void setWords(Word words) {
        this.words = words;
    }*/

    public Long getTranslationId() {
        return translationId;
    }

    public Long getWord1Id() {
        return word1Id;
    }

    public Long getWord2Id() {
        return word2Id;
    }

    /*public Word getWords() {
        return words;
    }*/

    protected Translations() {
    }

    public Translations(Long word1Id, Long word2Id /*Word words*/) {
        this.word1Id = word1Id;
        this.word2Id = word2Id;
        //this.words = words;
    }
}
