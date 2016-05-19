package com.iTeam.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *  Created by rahuldhamnani
* About the class
* Transaction class creates the blueprint for Users table in MySQL database.
* It maps columns in SQL table Users and Object of type user.
* All the variables are private and we have getter setter methods to excess them.
*
 */

@Entity
@Table
public class Users implements Serializable
{

	private static final long serialVersionUID = -1086683295069300962L;

	@Id
	@Column(name = "UserEmailID")
	private String email;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;


	@Column(name="PASSWORD")
	private String password;


	public Users() {

	}

	public Users(String email, String firstName, String lastName, String password) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
