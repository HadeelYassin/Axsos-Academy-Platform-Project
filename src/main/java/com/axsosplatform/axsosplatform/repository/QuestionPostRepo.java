package com.axsosplatform.axsosplatform.repository;

import com.axsosplatform.axsosplatform.models.QuestionPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionPostRepo extends CrudRepository<QuestionPost,Long> {

List<QuestionPost> findByTitleOrBodyContains(String question,String q);
}
