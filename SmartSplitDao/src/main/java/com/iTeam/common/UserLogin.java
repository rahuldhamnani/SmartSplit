package com.iTeam.common;

/**
 * Created by ashwinipprabhu
 * About the class
 * UserLogin class is blueprint used to handle user login functionality.
 * It has variables required to validate user and his/her password from database.
 * All the variables are kept private and we have getters and setters to access them
 */
public class UserLogin {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String exists;

    public UserLogin() {
    }

    public UserLogin(String email, String firstName, String lastName, String password, String exists) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.exists = exists;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getExists() {
        return exists;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setExists(String exists) {
        this.exists = exists;
    }

}
