package com.axsosplatform.axsosplatform.models.repository;

import com.axsosplatform.axsosplatform.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TagRepository extends CrudRepository<Tag,Long> {
}
