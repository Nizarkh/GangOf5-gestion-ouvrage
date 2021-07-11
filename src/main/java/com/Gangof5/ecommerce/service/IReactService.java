package com.Gangof5.ecommerce.service;

import java.util.List;

import com.Gangof5.ecommerce.model.React;

public interface IReactService {
    List<React> getAllPostLikes(int id);
    React addReact(React c);
    void deleteReact(int id);
    React updateReact(React c);
}
