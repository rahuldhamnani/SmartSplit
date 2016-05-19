package com.iTeam.common;

/**
 * Created by ashwinipprabhu
 * About the class
 * UserBalance blueprint created to handle json objects of type UserBalance specially for user balance page.
 * All the variables are private and we have getter setters to access them.
 */

public class UserBalance {

	private String firstName;
	private String lastName;
	private Double balance;
	private String friendsEmail;

	public UserBalance()
	{}

	public UserBalance(String firstName, String lastName, Double balance, String friendsEmail) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		this.friendsEmail = friendsEmail;
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
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getFriendsEmail() {
		return friendsEmail;
	}

	public void setFriendsEmail(String friendsEmail) {
		this.friendsEmail = friendsEmail;
	}
}
