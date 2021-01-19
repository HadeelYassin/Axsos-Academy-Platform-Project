package com.axsosplatform.axsosplatform.models.repository;


import com.axsosplatform.axsosplatform.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
