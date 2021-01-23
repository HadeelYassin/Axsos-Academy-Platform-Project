package com.axsosplatform.axsosplatform.repository;

import com.axsosplatform.axsosplatform.models.QuestionPost;
import com.axsosplatform.axsosplatform.models.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TagRepository extends CrudRepository<Tag,Long> {
    List<Tag> findAll();

    @Query(value="select qp.* from qposts qp , qp_tags  qpt ,typeo t where qp.id=qpt.qp_id and qp.type_id= t.id and qpt.tag_id=?1 and  t.kind =?2", nativeQuery=true)
    List<Object[]> getquestions(Long tid,String ques);


}
