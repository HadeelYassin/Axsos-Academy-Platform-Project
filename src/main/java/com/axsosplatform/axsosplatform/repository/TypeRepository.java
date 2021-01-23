package com.axsosplatform.axsosplatform.repository;


import com.axsosplatform.axsosplatform.models.TypeO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository  extends CrudRepository<TypeO, Long> {
    TypeO findByKind(String kind);
}
