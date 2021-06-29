package com.Gangof5.ecommerce.service;

import java.util.List;

import com.Gangof5.ecommerce.model.Post;

public interface IPostService {
    List<Post> retrieveAllPosts();
    Post addPost(Post c);
    void deletePost(String id);
    Post updatePost(Post c);
    Post retrievePost(String id);
}
