package com.Gangof5.ecommerce.service;

import java.util.List;

import com.Gangof5.ecommerce.model.BadWord;

public interface IBadWordService {
    List<BadWord> retrieveAllBadWords();
    BadWord addBadWord(BadWord c);
    void deleteBadWord(int id);
    BadWord updateBadWord(BadWord c);
    BadWord retrieveBadWord(int id);
}
