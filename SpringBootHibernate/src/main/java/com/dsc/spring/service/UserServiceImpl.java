/**
 * UserServiceImpls.java
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
package com.dsc.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsc.spring.entity.User;
import com.dsc.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;

	/**
	 * save Method
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public User save(User user) 
	{
		return userRepository.save(user);
	}

	/**
	 * findById Method
	 * 
	 * @param Id
	 * @return
	 */
	@Override
	public User findById(Integer Id) 
	{
		Optional<User> retUser = null;
		
		retUser = userRepository.findById(Id);
		
		/*
		 * Optional check for return value
		 */
		if (retUser.isPresent())
			return retUser.get();
		else
			return null;
	}

    /**
     * findAll Method
     * 
     * @return
     */
	@Override
	public List<User> findAll() 
	{
		return (List<User>) userRepository.findAll();
	}

    /**
     * delete Method
     * 
     * @param user
     */
	@Override
	public void delete(User user) 
	{
		userRepository.delete(user);
	}

    /**
     * findByIdRange Method
     * 
     * @param startId
     * @param endId
     * @return
     */
	@Override
	public List<User> findByIdRange(Integer startId, Integer endId) {
		return userRepository.findByIdRange(startId, endId);
	}
	
	
}
