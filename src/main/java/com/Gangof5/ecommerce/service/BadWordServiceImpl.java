package com.Gangof5.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gangof5.ecommerce.model.BadWord;
import com.Gangof5.ecommerce.repository.BadWordRepository;

import java.util.List;
@Service
public class BadWordServiceImpl implements IBadWordService{

    @Autowired
    BadWordRepository badwordRepository;

    @Override
    public List<BadWord> retrieveAllBadWords() {
        return (List<BadWord>) badwordRepository.findAll();
    }

    @Override
    public BadWord addBadWord(BadWord b) {
        return  badwordRepository.save(b);
    }

    @Override
    public void deleteBadWord(String id) {
        badwordRepository.deleteById(Integer.parseInt(id));
    }

    @Override
    public BadWord updateBadWord(BadWord b) {
        return  badwordRepository.save(b);
    }

    @Override
    public BadWord retrieveBadWord(String id) {
        return badwordRepository.findById(Integer.parseInt(id)).get();
    }
}
