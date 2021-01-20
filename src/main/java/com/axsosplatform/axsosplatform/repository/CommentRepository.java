package com.axsosplatform.axsosplatform.repository;

import com.axsosplatform.axsosplatform.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {

}
