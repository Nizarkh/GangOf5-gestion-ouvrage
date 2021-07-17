package com.Gangof5.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Gangof5.ecommerce.dto.cart.CartItemDto;
import com.Gangof5.ecommerce.model.Cart;
import com.Gangof5.ecommerce.model.Comment;
import com.Gangof5.ecommerce.service.CommentServiceImpl;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentServiceImpl commentService ;

    @PostMapping("/api/comments/add")
    @ResponseBody
    public void addComment (@RequestBody Comment c,@RequestParam("token") String token){
        commentService.addComment(c,token);
    }

    @PutMapping("/api/comments/update")
    @ResponseBody
    public void updateComment (@RequestBody Comment c){
        commentService.updateComment(c);
    }

    @DeleteMapping("/api/comments/delete/{id}")
    @ResponseBody
    public void  deleteComment (@PathVariable("id")String id){
        commentService.deleteComment(Integer.parseInt(id));
    }

    @GetMapping("/api/comments/all")
    public List<Comment> retrieveAllComments() {
        return commentService.retrieveAllComments();
    }
    
    @GetMapping("/api/comments/{id}")
    public List<Comment> getPostComments(@PathVariable("id")String id) {
    	List<Comment> comments = commentService.getPostComments(Integer.parseInt(id));
    	for (Comment comment:comments){
    		comment.setPost(null);
        }
        return comments;
    }
}
