package com.examServer.ExamServer;

import com.examServer.ExamServer.model.Role;
import com.examServer.ExamServer.model.User;
import com.examServer.ExamServer.model.UserRole;
import com.examServer.ExamServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamServerApplication  implements CommandLineRunner {

	@Autowired
	private UserService us;
@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*
		System.out.println("starting command line runner");
		User user = new User();
		user.setFirstName("Ayush");
		user.setLastName("Agnihotri");
		user.setUsername("ayushagni");
		user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
		user.setEmail("abc@gmail.com");
		user.setProfile("default.png");

		Role role1=new Role();
		role1.setRoleId(44L);
		role1.setRoleName("ADMIN");

		Set<UserRole> userRoleSet=new HashSet<>();
		UserRole userRole=new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		userRoleSet.add( userRole);

		User user1 = this.us.createUser(user, userRoleSet);
		System.out.println("usernamer is"+user1.getUsername());

*/


	}
}
