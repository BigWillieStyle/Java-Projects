/**
 * UserService.java
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
package com.dsc.blockchain.service;

import java.util.List;
import java.util.Optional;

import com.dsc.blockchain.entity.User;

public interface UserService 
{
	/**
	 * save Method
	 * 
	 * @param user
	 * @return
	 */
	public User save(User user);
	
	/**
	 * findById Method
	 * 
	 * @param Id
	 * @return
	 */
    public User findById(Integer Id);       

    /**
     * findAll Method
     * 
     * @return
     */
    public List<User> findAll();          

    /**
     * delete Method
     * 
     * @param user
     */
    public void delete(User user);   
    
    /**
     * findByIdRange Method
     * 
     * @param startId
     * @param endId
     * @return
     */
    public List<User> findByIdRange(Integer startId, Integer endId);
}
