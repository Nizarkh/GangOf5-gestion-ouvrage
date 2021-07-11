package com.Gangof5.ecommerce.service;

import java.util.List;

import com.Gangof5.ecommerce.model.Post;

public interface IPostService {
    List<Post> retrieveAllPosts();
    List<Post> getMyPosts(String token);
    Post addPost(Post c);
    void deletePost(int id);
    Post updatePost(Post c);
    Post retrievePost(int id);
}
