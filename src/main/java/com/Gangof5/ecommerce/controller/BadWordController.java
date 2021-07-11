package com.Gangof5.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Gangof5.ecommerce.model.BadWord;
import com.Gangof5.ecommerce.service.BadWordServiceImpl;

import java.util.List;

@RestController
public class BadWordController {
    @Autowired
    BadWordServiceImpl badWordService ;

    @PostMapping("/api/badwords/add")
    @ResponseBody
    public void addComment (@RequestBody BadWord b){
        badWordService.addBadWord(b);
    }

    @PutMapping("/api/badwords/update")
    @ResponseBody
    public void updateComment (@RequestBody BadWord b){
        badWordService.updateBadWord(b);
    }

    @DeleteMapping("/api/badwords/delete/{id}")
    @ResponseBody
    public void  deleteComment (@PathVariable("id")String id){
        badWordService.deleteBadWord(Integer.parseInt(id));
    }

    @GetMapping("/api/badwords/all")
    public List<BadWord> retrieveAllComments() {
        return badWordService.retrieveAllBadWords();
    }
}
