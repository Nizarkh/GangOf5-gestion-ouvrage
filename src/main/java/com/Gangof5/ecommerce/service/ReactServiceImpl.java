package com.Gangof5.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gangof5.ecommerce.model.Post;
import com.Gangof5.ecommerce.model.React;
import com.Gangof5.ecommerce.repository.PostRepository;
import com.Gangof5.ecommerce.repository.ReactRepository;
@Service
public class ReactServiceImpl  implements IReactService{

    @Autowired
    ReactRepository reactRepository;
    @Autowired
    PostRepository postRepository;
    
    @Override
    public List<React> getAllPostLikes(int id) {
        Post p = postRepository.findById(id).get();
        return p.getReacts();
    }

    @Override
    public React addReact(React r) {
        return reactRepository.save(r);
    }

    @Override
    public void deleteReact(int id) {
    	reactRepository.deleteById(id);
    }

    @Override
    public React updateReact(React r) {
        return reactRepository.save(r);
    }

}
