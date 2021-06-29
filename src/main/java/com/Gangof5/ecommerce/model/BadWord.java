package com.Gangof5.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BadWord{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String word;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public BadWord() {
        super();
    }

    public BadWord(int id, String word) {
        this.id = id;
        this.word = word;
    }
}
