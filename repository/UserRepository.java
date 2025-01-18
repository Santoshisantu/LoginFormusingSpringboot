package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	  @Query(value = "SELECT * FROM user WHERE username = :username AND userpwd = :userpwd", nativeQuery = true)
	    User findByNameAndPassword(@Param("username") String username, @Param("userpwd") String userpwd);

	//Object findByName(String username);
	// findByUsernameAndPwd(String username,String userpwd);

}
