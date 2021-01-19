package com.axsosplatform.axsosplatform.models.repository;

import com.axsosplatform.axsosplatform.models.QuestionPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionPostRepo extends CrudRepository<QuestionPost,Long> {
}
