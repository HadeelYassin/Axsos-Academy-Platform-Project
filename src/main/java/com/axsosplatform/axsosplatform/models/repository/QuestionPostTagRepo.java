package com.axsosplatform.axsosplatform.models.repository;

import com.axsosplatform.axsosplatform.models.QuestionPostTag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionPostTagRepo extends CrudRepository<QuestionPostTag,Long> {
}
