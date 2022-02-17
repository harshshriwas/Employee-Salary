package com.user.register;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.register.model.UserRepo;
import com.user.register.model.Users;

@RestController
public class RegistrationController {

	@Autowired
	private UserRepo userRepo;
	
	//For ragister user
	@RequestMapping("/register-user/{email}/{password}/{firstname}/{lastname}/{userdoj}")
	public String registerUser(@PathVariable("email") String userEmail,@PathVariable("password") String password,
			@PathVariable("firstname") String firstName,@PathVariable("lastname") String lastName,@PathVariable("userdoj") String userDOJ)
	{
		Users user = new Users();
		user.setId(1);
		user.setEmail(userEmail);
		user.setPassword(password);
		user.setFirstname(firstName);
		user.setLastname(lastName);
		user.setUserDOJ(userDOJ);
		userRepo.save(user);
		return "Successfully Register!!";
	}
	
	//for getting All the employee
	@GetMapping("/allusers")
	public List<Users> getAllUsers(){
		return userRepo.findAll();
	}
	
	//This is for get user by id
	@GetMapping("/allusers/{id}")
	public  Users getUsersById(@PathVariable Integer id){
			
		Optional<Users> user = userRepo.findById(id);
		return user.get();
	}
	
	//this is for update user
	@GetMapping("/allusers/update/{id}")
	public  Users updateUsersById(@PathVariable Integer id){
			
		Optional<Users> user = userRepo.findById(id);
		Users u = user.get(); 
		u.setEmail("Harsh@shriwas");
		u.setFirstname("Harsh");
		u.setLastname("Shriwas");
		userRepo.save(u);
		return user.get();
	}
	
	//This is for delete user by id
	@GetMapping("/allusers/delete/{id}")
	public  String deleteUsersById(@PathVariable Integer id){
			
		userRepo.deleteById(id);
		return "Successfully deleted";
	}
}
