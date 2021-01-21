package com.axsosplatform.axsosplatform.repository;

import com.axsosplatform.axsosplatform.models.User;
import com.axsosplatform.axsosplatform.models.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository <Role,Long>{
    List<Role> findByName(String name);
}
