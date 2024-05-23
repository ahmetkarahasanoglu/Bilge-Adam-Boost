package com.ahmet.entity;

import java.util.Date;

public class User {

	/*
	 * POJO -> Plain Old Java Object
	 * en basit java sınıfı.
	 */
	
	Long id;
	String name;
	String username;
	String password;
	String dateCreated;
	
	
	
	@Override
	public String toString() { // 'TO STRING' METODU: EKRANA SAĞ TIKLAYIP --> Source --> Generate toString()  yaptığımızda otomatik geliyor.
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", dateCreated=" + dateCreated + "]";
	}

	// Constructor
	public User() {
		this.dateCreated = new Date().toString();		
	}

	// Constructor with Parameters
	public User(Long id, String name, String username, String password) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.dateCreated = new Date().toString();
	}
	
	//Getters and Setters:
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
