package com.manage.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.manage.salary.model.UserRepo;
import com.manage.salary.model.Users;

//import com.manage.salary.model.UserRepo;
//import com.manage.salary.model.Users;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepo repo; 
	
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping("/")
	public String getLogin()
	{
		return "login";
	}
	
	@RequestMapping("/login")
	public String getHome(@RequestParam("userEmail") String userEmail,@RequestParam("userPassword") String userPassword,Model model)
	{
		//repo.findByName("userEmail");
		
		Users user = null;
		try {
			user = repo.findByEmail(userEmail);
		}
		catch(Exception e)
		{
			System.out.println("user not found!!"+e);
		}
		if(user!=null)
		{
			model.addAttribute("UserEmail", userEmail);
			return "homepage";			
		}

		return "login";
	}
	
	@RequestMapping("/register")
	public String registerUser()
	{
		return "register";
	}
	
	@RequestMapping("/set-user")
	public String setRegisterUser(@RequestParam("email") String userEmail,@RequestParam("password") String password,
			@RequestParam("firstname") String firstName,@RequestParam("lastname") String lastName,@RequestParam("userdoj") String userDOJ,Model model)
	{
		System.out.println("edhar mar gaya aa kar ab kya kare...........");
		System.out.println("Email is = "+userEmail);
		System.out.println("Password = "+password);
		System.out.println("firstname = "+firstName);
		System.out.println("LastName = "+lastName);
		System.out.println("User Date of joining = "+userDOJ);
		
		  restTemplate.getForObject("http://localhost:8081/register-user/"+userEmail+"/"+password+"/"+firstName+"/"+lastName+"/"+userDOJ,String.class);
		 		
		return "login";		
	}
}
