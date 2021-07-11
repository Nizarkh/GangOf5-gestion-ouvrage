package com.Gangof5.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Gangof5.ecommerce.model.Post;
import com.Gangof5.ecommerce.model.React;
import com.Gangof5.ecommerce.service.ReactServiceImpl;

@RestController
public class ReactController {
    @Autowired
    ReactServiceImpl reactService ;

    @PostMapping("/api/reacts/add")
    @ResponseBody
    public void addReact (@RequestBody React p){
    	reactService.addReact(p);
    }

    @PutMapping("/api/reacts/update")
    @ResponseBody
    public void updateReact (@RequestBody React p){
    	reactService.updateReact(p);
    }

    @DeleteMapping("/api/reacts/delete/{id}")
    @ResponseBody
    public void  deleteReact (@PathVariable("id")String id){
    	reactService.deleteReact(Integer.parseInt(id));
    }

    @GetMapping("/api/reacts/{id}")
    public List<React> getAllPostLikes(@PathVariable("id")String id) {
    	List<React> reacts = reactService.getAllPostLikes(Integer.parseInt(id));
        for(React react:reacts){
        	react.setPost(null);
        }
    	return reacts;
    }
}
