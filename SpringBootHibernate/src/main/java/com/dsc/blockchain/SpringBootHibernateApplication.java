/**
 * SpringBootHibernateApplication.java
 * 
 * SpringBootHibernate demo project 
 * 
 * Demo project using: 
 * 		Spring Boot
 * 		Spring JPA
 * 		H2 in memory DB
 *  
 *  To show CRUD operations using Spring CrudRepository interface
 *  for data persistence.
 * 
 * Created by William Williams on 4/07/18.
 * Copyright © 2018 DSC. All rights reserved.
 */
package com.dsc.blockchain;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dsc.blockchain.entity.User;
import com.dsc.blockchain.service.UserService;

@SpringBootApplication
public class SpringBootHibernateApplication  implements CommandLineRunner
{
	@Autowired
	UserService userService;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		User demoUser = null;
		
		Integer demoUserId = new Integer(63);
		
		int rangeOffset = 10;
		
		// Output all users
		List<User> userList = userService.findAll();	
		
		for (User user : userList)
		{
			System.out.println("User Id "+ user.getId() +" "+user.getFirstName()+" "+ user.getMiddleName()+" "+user.getLastName());
		}
		
		// Fetch user record for Id demoUserId
		demoUser = userService.findById(demoUserId);
		
		System.out.println("Demo User Id "+ demoUser.getId() +" "+demoUser.getFirstName()+" "+ demoUser.getMiddleName()+" "+demoUser.getLastName());
		
		// Update user record middle name
		demoUser.setMiddleName("Demo Middle Name");
		
		userService.save(demoUser);
		
		// Clear and fetch the updated record to validate
		demoUser = null;
		
		demoUser = userService.findById(demoUserId);
		
		System.out.println("Demo User Id "+ demoUser.getId() +" "+demoUser.getFirstName()+" "+ demoUser.getMiddleName()+" "+demoUser.getLastName());

		// Delete record Id demoUserId
		userService.delete(demoUser);
		
		
		// Fetch user record for Id demoUserId
		demoUser = userService.findById(demoUserId);
		
		if (demoUser == null)
			System.out.println("Demo User Id "+ demoUserId +" has been deleted");
	
		
		// Output users with range
		
		userList = userService.findByIdRange(demoUserId-10, demoUserId+10);	

		System.out.println("Retrieve all Demo User records with an ID between "+ (demoUserId-rangeOffset) +" and "+(demoUserId+rangeOffset)+".");

		for (User user : userList)
		{
			System.out.println("User Id "+ user.getId() +" "+user.getFirstName()+" "+ user.getMiddleName()+" "+user.getLastName());
		}
		
	}
}
