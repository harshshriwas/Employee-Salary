package com.user.register.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Integer>{

//	public Users findByUserEmail(String userEmail);

	public Users findByEmail(String userEmail);


}

