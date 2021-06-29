package com.Gangof5.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Gangof5.ecommerce.model.Comment;
import com.Gangof5.ecommerce.service.CommentServiceImpl;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentServiceImpl commentService ;

    @PostMapping("/api/comments/add")
    @ResponseBody
    public void addComment (@RequestBody Comment c){
        commentService.addComment(c);
    }

    @PutMapping("/api/comments/update")
    @ResponseBody
    public void updateComment (@RequestBody Comment c){
        commentService.updateComment(c);
    }

    @DeleteMapping("/api/comments/delete/{id}")
    @ResponseBody
    public void  deleteComment (@PathVariable("id")String id){
        commentService.deleteComment(id);
    }

    @GetMapping("/api/comments/all")
    public List<Comment> retrieveAllComments() {
        List<Comment> comments;
        comments = commentService.retrieveAllComments();
        return comments;
    }
}
