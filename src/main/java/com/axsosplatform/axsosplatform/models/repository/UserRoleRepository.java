package com.axsosplatform.axsosplatform.models.repository;

import com.axsosplatform.axsosplatform.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<User,Long> {
}
