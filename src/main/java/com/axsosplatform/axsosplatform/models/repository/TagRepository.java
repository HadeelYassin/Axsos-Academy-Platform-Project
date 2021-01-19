package com.axsosplatform.axsosplatform.models.repository;

import com.axsosplatform.axsosplatform.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TagRepository extends CrudRepository<Tag,Long> {
    List<Tag> findALL();
    List<Tag> findTagBy(Tag tag);
    List<Tag> findDistinctBy(Tag tag);
    List<Tag> findLabelBy(String title);
}
