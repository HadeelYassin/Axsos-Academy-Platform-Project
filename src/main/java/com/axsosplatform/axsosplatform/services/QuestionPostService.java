package com.axsosplatform.axsosplatform.services;
import com.axsosplatform.axsosplatform.models.QuestionPost;
import com.axsosplatform.axsosplatform.repository.QuestionPostRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionPostService  {

    private  final QuestionPostRepo questionPostRepo;


    public QuestionPostService(QuestionPostRepo questionPostRepo) {
        this.questionPostRepo = questionPostRepo;
    }
    public QuestionPost getQuestionPostById(Long id){
        return this.questionPostRepo.findById(id).orElse(null);
    }


    public QuestionPost addYourQuestionPost(QuestionPost questionPost){
        return questionPostRepo.save(questionPost);
    }


    public QuestionPost editYourQuestionPost(QuestionPost questionPost){
        return questionPostRepo.save(questionPost);
    }
    public List<QuestionPost> findsearchResult(String question,String q){
    return this.questionPostRepo.findByTitleOrBodyLike(question,q);
}

}
