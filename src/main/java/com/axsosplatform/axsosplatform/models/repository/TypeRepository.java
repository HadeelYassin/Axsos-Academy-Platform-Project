package com.axsosplatform.axsosplatform.models.repository;


import com.axsosplatform.axsosplatform.models.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository  extends CrudRepository<Type, Long> {
}
