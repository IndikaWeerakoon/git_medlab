package com.fullbright.medlab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fullbright.medlab.entities.User;
import com.fullbright.medlab.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query(value  = "SELECT * FROM user u WHERE u.username = (:username) AND u.password = (:password)", nativeQuery = true)
	User findUser(@Param("username") String username, @Param("password") String password);
	
	
}
