package com.location.web.flight.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.location.web.flight.entities.User;
import com.location.web.flight.repos.UserRepository;
import com.location.web.flight.services.SecurityService;

import ch.qos.logback.classic.Logger;

@Controller
public class UserController {

	@Autowired
	private UserRepository ur;
	
	private static final org.slf4j.Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private SecurityService ss;
	
	@Autowired
	private  BCryptPasswordEncoder end;
	@RequestMapping("/reg")
	public String showRegistrationPage()
	{
		LOGGER.info("Inside showRegistrationPage()");
		return "login/registerUser";
	}
	
	@RequestMapping("/logins")
	public String showLoginPage()
	{
		LOGGER.info("Inside showLoginPage()");
		return "login/login";
	}
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public String register(@ModelAttribute("user") User user)
	{
		LOGGER.info("Inside register()"+user);
		user.setPassword(end.encode(user.getPassword()));
		ur.save(user);
		return "login/login";
		
	}
	
	
	
	
	@RequestMapping(value="/logined",method=RequestMethod.POST)
	public String login(@RequestParam("email") String  email,@RequestParam("password") String password,ModelMap mmap)
	{
		LOGGER.info("Inside Login and email is "+email);
		
		boolean loginres = ss.login(email, password);
		if(loginres)
		{
			return "findFlights";
		}else {
			mmap.addAttribute("msg", "Invalid Username/Password.Please try again ");
		}
		/*User user = ur.findByEmail(email);
		if(user.getPassword().equals(password))
		{
			return "findFlights";
		}else {
			mmap.addAttribute("msg", "Invalid Username/Password.Please try again ");
		}*/
		return "login/login";
	}
}
