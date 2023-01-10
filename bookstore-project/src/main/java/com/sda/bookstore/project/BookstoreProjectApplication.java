package com.sda.bookstore.project;

import com.sda.bookstore.project.config.SecurityConfig;
import com.sda.bookstore.project.model.Role;
import com.sda.bookstore.project.model.User;
import com.sda.bookstore.project.model.UserRole;
import com.sda.bookstore.project.service.UserService;
import com.sda.bookstore.project.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class BookstoreProjectApplication implements CommandLineRunner {
		//implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user2 = new User();
		user2.setFirstName("John");
		user2.setLastName("Doe");
		user2.setUsername("johnDoe");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("joe"));
		user2.setEmail("inspirebookstore23@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role2 = new Role();
		role2.setRoleId(2);
		role2.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user2, role2));

		userService.createUser(user2, userRoles);
	}




}
