package com.vicitf.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicitf.springboot.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsernameAndPassword(String username, String password);
}
