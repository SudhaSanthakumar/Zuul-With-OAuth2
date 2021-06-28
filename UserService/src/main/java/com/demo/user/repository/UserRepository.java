package com.demo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String userName);

}
