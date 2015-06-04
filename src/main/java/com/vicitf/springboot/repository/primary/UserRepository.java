package com.vicitf.springboot.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vicitf.springboot.domain.primray.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsernameAndPassword(String username, String password);
	
	@SuppressWarnings("unchecked")
	User save(User user);
	
}
