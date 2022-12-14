package com.example.yearupSpring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;

import javax.persistence.GeneratedValue;


/**
 * 	This class represents a table in out database. (Entity)
 *  Every instance of this class represents a row in that table.
 *  
 * 
 * @author edwin
 *
 */

//user is a reserved word in our database, so we can't use it here, instead
//we can tell spring that User entity represent the table user_inf
@Entity(name = "user_inf")
public class User {
	
	@Id
	@GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	@Column(nullable = false)
	private String name; 
	
	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private byte[] password;

	public User(){}

	public User(Integer id, String name, String username, byte[] password){
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public byte[] getPassword() {
		return password;
	}


	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return String.format("id:%d name: %s username: %s", id,name, username);
	}
	
	
}
