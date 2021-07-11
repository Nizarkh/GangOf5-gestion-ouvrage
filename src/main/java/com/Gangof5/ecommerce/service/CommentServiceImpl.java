package com.Gangof5.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gangof5.ecommerce.model.BadWord;
import com.Gangof5.ecommerce.model.Comment;
import com.Gangof5.ecommerce.model.Post;
import com.Gangof5.ecommerce.repository.BadWordRepository;
import com.Gangof5.ecommerce.repository.CommentRepository;
import com.Gangof5.ecommerce.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    BadWordRepository bwRepository;
    @Autowired
    PostRepository postRepository;
    @Override
    public List<Comment> retrieveAllComments() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public Comment addComment(Comment c) {
        return checkBadWord(c);
    }

    @Override
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment updateComment(Comment c) {
        return checkBadWord(c);
    }

    private Comment checkBadWord(Comment c) {
        List<String> badWords = new ArrayList<String>();
        List<BadWord> originalWords =(List<BadWord>) bwRepository.findAll();
        for(BadWord word : originalWords ) {
            badWords.add(word.getWord());
        }   
        String[] comWords = c.getText().split(" ");
        for(String w : comWords ) {
        	if(badWords.contains(w)){
                String censored = new String(new char[w.length()]).replace("\0", "*");
                String newCom=c.getText().substring(0,c.getText().indexOf(w))+censored+c.getText().substring(c.getText().indexOf(w)+w.length());
                c.setText(newCom);
            }
        }
        return  commentRepository.save(c);
    }

    @Override
    public Comment retrieveComment(int id) {
        return commentRepository.findById(id).get();
    }
    @Override
    public List<Comment> getPostComments(int id)
    {
        Post p = postRepository.findById(id).get();
        return p.getComments();
    }
}
