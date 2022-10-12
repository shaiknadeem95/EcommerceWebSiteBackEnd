package com.shopping.admin.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopping.common.entity.Role;

@Repository("RoleRepository")
public interface RoleRepository extends CrudRepository<Role,Integer> {

}
