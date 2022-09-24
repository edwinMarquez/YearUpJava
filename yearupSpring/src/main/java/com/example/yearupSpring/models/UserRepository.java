package com.example.yearupSpring.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * A repository on spring represents what would be a 
 * DAO (Data Access Object), creates a separation between your application and your database, 
 * where your application is only concern on the DAO. and does not worry
 * on specifics i.e what database (if any) is used.  
 * 
 * @author edwin
 *
 */
public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query("SELECT new com.example.yearupSpring.models.User(id, name, username, password) FROM user_inf WHERE username = ?1")
    User findByUsername(String username);

}
