package com.axsosplatform.axsosplatform.services;

import com.axsosplatform.axsosplatform.models.Comment;
import com.axsosplatform.axsosplatform.models.QuestionPost;
import com.axsosplatform.axsosplatform.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }



    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }


    public Comment edit(Comment comment){
        return commentRepository.save(comment);
    }


}
