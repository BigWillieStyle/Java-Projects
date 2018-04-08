/**
 * User.java
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
package com.dsc.blockchain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User 
{
	@Id
	@GeneratedValue
	private Integer id;
	private String firstName;
	private String lastName;
	private String middleName;
	
	public Integer getId() 
	{
		return id;
	}
	
	public void setId(Integer id) 
	{
		this.id = id;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String getMiddleName() 
	{
		return middleName;
	}
	
	public void setMiddleName(String middleName) 
	{
		this.middleName = middleName;
	}
}
