package com.bridgelabz.employeepayrollapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bridgelabz.employeepayrollapp.model.User;

public interface IUserRepository extends JpaRepository<User, Integer>{

	@Query("select user from User user where user.userName=:name or user.password=:password")
    public User getUserDetails(@Param("name") String userName, @Param("password") String password);
}
