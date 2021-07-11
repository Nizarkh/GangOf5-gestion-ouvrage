package com.Gangof5.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Gangof5.ecommerce.model.Comment;
import com.Gangof5.ecommerce.model.Post;
import com.Gangof5.ecommerce.service.PostServiceImpl;


@RestController
public class PostController {
    @Autowired
    PostServiceImpl postService ;

    @PostMapping("/api/posts/add")
    @ResponseBody
    public void addPost (@RequestBody Post p){
        postService.addPost(p);
    }

    @PutMapping("/api/posts/update")
    @ResponseBody
    public void updatePost (@RequestBody Post p){
        postService.updatePost(p);
    }

    @DeleteMapping("/api/posts/delete/{id}")
    @ResponseBody
    public void  deletePost (@PathVariable("id")String id){
        postService.deletePost(Integer.parseInt(id));
    }

    @GetMapping("/api/posts/all")
    public List<Post> retrieveAllPosts() {
        List<Post> posts;
        posts = postService.retrieveAllPosts();
    	for (Post post:posts){
    		post.setComments(null);
    		post.setReacts(null);
        }
        return posts;
    }
    @GetMapping("/api/posts/my")
    public List<Post> getMyPosts(@RequestParam("token") String token) {
        List<Post> posts;
        posts = postService.getMyPosts(token);
    	for (Post post:posts){
    		post.setComments(null);
    		post.setReacts(null);
        }
        return posts;
    }
}
