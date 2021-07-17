package com.Gangof5.ecommerce.service;

import java.util.List;

import com.Gangof5.ecommerce.model.Comment;

public interface ICommentService {
    List<Comment> retrieveAllComments();
    Comment addComment(Comment c,String token);
    void deleteComment(int id);
    Comment updateComment(Comment c);
    Comment retrieveComment(int id);
    List<Comment> getPostComments(int id);
}
