package com.iTeam.dao;

import com.iTeam.common.Users;


import java.util.ArrayList;

public interface UsersDao
{
	 String addUser(Users user) throws Exception;
	 Users getUser(String emailID);
	String updateUser(Users usr);
	 String deleteUser(String emailID);
	String findEmailID(String fName, String lName);

}
