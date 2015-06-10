package com.vicitf.springboot.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.vicitf.springboot.domain.primray.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsernameAndPassword(String username, String password);
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#save(S)
	 */
	@SuppressWarnings("unchecked")
	User save(User user);
	
	/**
	 * 用户名是否存在
	 * 
	 * @param username
	 * @return
	 */
	Integer existsByUsername(String username);
	
	/**
	 * 修改登陆地址
	 * 
	 * @param loginAddress
	 * @param id
	 * @return
	 */
	@Transactional("primaryTransactionManager")
	@Modifying
	@Query(value = "update User u set u.loginAddress = ?1 where u.id = ?2")
	int updateLoginAddress(String loginAddress, Long id);
	
	/**
	 * 修改个人信息
	 * 
	 * @param avatar
	 * @param realname
	 * @param email
	 * @param female
	 * @param id
	 * @return
	 */
	@Transactional("primaryTransactionManager")
	@Modifying
	@Query(value = "update User u set u.avatar = ?1, u.realname = ?2, u.email = ?3, u.gender = ?4 where u.id = ?5")
	int updateProfile(String avatar, String realname, String email, String gender, Long id);
}
