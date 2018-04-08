/**
 * UserRepository.java
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
package com.dsc.blockchain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dsc.blockchain.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>
{
    @Query("SELECT u FROM User u WHERE u.id BETWEEN :startId AND :endId")
    public List<User> findByIdRange(@Param("startId") Integer startId, @Param("endId") Integer endId);
}
