package com.iTeam.dao;

import com.iTeam.common.SQLExecutionHandler;
import com.iTeam.common.Users;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * created by rahuldhamnani
 *
 * About the Class -
 * UserDapImpl implements UserDao interface.
 * It contains all the DAO functionalities related to User of out system.
 * Below are the method and there description.
 * The test case for this class is written in UserDoaImplTest class located at test.java.com.iTeam
 *
 * Methods  ---    Description
 * addUser - The method takes User data type as input to create a new user in database
 * getUser - The method take UserEmailID as input and extracts information about user
 * updateUser - The method takes three inputs
 * 					1. User Email ID
 * 					2. Update Value
 * 					3. Type to update 'f' - FirstName 'l' - LastName 'p' - Password
 * 				based on the input the updation is performed
 *
 * deleteUser - The method deletes the user from database. This method has no uses
 * 				from functionality point of view but was created to add test user and then delete
 * 				after the test case was executed.
 */

public class UserDaoImpl implements UsersDao{
	private static Logger logger = Logger.getLogger("UserDao");
	private SQLExecutionHandler sql = new SQLExecutionHandler();

	public String addUser(Users user) throws Exception {

		logger.debug("In addUser Function \n <-----------ADDING NEW USER----------->");
		sql.addSQL(user);
		return "success";
	}

	public Users getUser(String emailID)
	{
		final String query ="select users.UserEmailId, users.FirstName, users.LastName, users.password from SmartSplitDB.Users where users.UserEmailid =  '" + emailID.toLowerCase() + "';";
		logger.debug("IN getUser Function \n <----------GETTING USER DETAILS--------->");
		List results = sql.executeSQL(query);

		ArrayList<Users> user = new ArrayList<Users>();

		for(Object object : results)
		{
			Map row = (Map)object;
			user.add( new Users(row.get("UserEmailID").toString() ,
			row.get("FirstName").toString(),
			row.get("LastName").toString(),
			row.get("Password").toString()));

		}

		return new Users(user.get(0).getEmail(), user.get(0).getFirstName(), user.get(0).getLastName(), user.get(0).getPassword());
	}

	public String updateUser(Users usr)
	{

		logger.debug("IN updateUser Function \n <---------UPDATING USER DETAILS--------->");

		String query = "UPDATE Users SET " +
				"FirstName = '"+ usr.getFirstName() +"' ," +
				"LastName = '"+ usr.getLastName() +"' ," +
				"Password = '"+ usr.getPassword() +"' " +
				"WHERE UserEmailID = '"+ usr.getEmail() +"';" ;
		int result = sql.updateSQL(query);
		if (result > 0 )
			return "success";
		else
			return "fail";

	}

	public String deleteUser(String emailID)
	{
		final String query ="DELETE FROM SmartSplitDB.Users where Users.UserEmailID = '" + emailID + "';";
		logger.debug("IN deleteUser Function \n <-------DELETING USER------->");
		int result = sql.updateSQL(query);
		if (result > 0 )
			return "success";
		else
			return "fail";
	}

	public String findEmailID(String fName, String lName)
	{
		final String query ="SELECT users.UserEmailId FROM SmartSplitDB.Users where lower(users.FirstName) =  '" + fName.toLowerCase() + "'" +
				" AND lower(users.LastName)='"+ lName.toLowerCase()+"';";
		List result = sql.executeSQL(query);
		Map row = (Map)result.get(0);
		return row.get("UserEmailID").toString();
	}
}
