package com.Gangof5.ecommerce.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gangof5.ecommerce.model.Post;
import com.Gangof5.ecommerce.repository.PostRepository;


@Service
public class PostServiceImpl implements IPostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> retrieveAllPosts() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public Post addPost(Post p) {
        return  postRepository.save(p);
    }

    @Override
    public void deletePost(int id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post updatePost(Post p) {
        return  postRepository.save(p);
    }

    @Override
    public Post retrievePost(int id) {
        Post p = postRepository.findById(id).get();
        return p;
    }
}
