package com.shopping.admin.user.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopping.common.entity.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByEmail(String email);
}
