package com.iTeam.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.iTeam.common.*;

/**
 *
 * Created by ashwiniprabhu, rahuldhamnani
 *
 * About the Class -
 * TransactionDoaImpl implements TransactionDao interface.
 * It contains all the DAO functionalities related to a Transaction (bill) of SmartSplit system.
 * Below are the method and there description.
 * The test case for this class is written in TransactionDoaImplTest class located at test.java.com.iTeam
 *
 * Methods  -       Description
 * addTransaction - The method takes Transaction data type as input to add a new bill in database
 * getFriendList - The method take UserEmailID as input and extracts friend list of user
 * getTotal - The method take UserEmailID as input and calculates the values for Dashboard page
 * getTransactionList - The method takes user's email and a friend's email and returns all the transaction
 * 						between these two people.
 * getSingleTransaction - The method take Transaction id as input and extract transaction from database
 * updateTransaction - The method takes a transaction object and updates all the modified values
 * checkUserPass - The method checks if the user exist in database or not. It is used for adding a bill on user.
 * deleteTransaction - The method deletes the user from database. This method has no uses
 * 				from functionality point of view but was created to add test user and then delete
 * 				after the test case was executed.
 */


public class TransactionsDaoImpl implements TransactionsDao
{
	private static Logger logger = Logger.getLogger("TransactionDao");
	private SQLExecutionHandler sql = new SQLExecutionHandler();


	public String addTransaction(Transactions transaction) throws Exception
	{

		logger.debug("IN addTransaction Function \n <----------ADDING NEW TRANSACTION--------->");
		String status = sql.addSQL(transaction);
		return status;
	}

	public ArrayList<UserBalance> getFriendsList(String email)
	{
		logger.debug("IN getFriendsList Function");
		final String query ="select users.FirstName , users.LastName, amt.amount as amount, amt.addTo from SmartSplitDB.users "
				+ "as users inner join (select trans.AddedTo as addTo, sum(trans.AmountOwe) as amount "
				+ "FROM SmartSplitDB.Transactions as trans "
				+ "where trans.Addedby = '"+email+"' group by trans.AddedTo) as amt "
				+ "on users.UserEmailID = amt.addTo;";


		List results = sql.executeSQL(query);

		ArrayList<UserBalance> balList = new ArrayList<UserBalance>();

		for(Object object : results)
		{
			Map row = (Map)object;
			balList.add(new UserBalance(row.get("FirstName").toString(), row.get("LastName").toString(),
					Double.valueOf(row.get("amount").toString()), row.get("addTo").toString()));
		}

		System.out.println(balList.size());

		for(UserBalance ubal : balList)
		{
			logger.info("Bal: " + ubal.getBalance());
			logger.info("Name: " + ubal.getFriendsEmail());
		}

		final String query2 = "select users.FirstName , users.LastName, amt.amount as amount, amt.addBy from SmartSplitDB.users "
				+ "as users inner join (select trans.AddedBy as addBy, sum(trans.AmountOwe) as amount "
				+ "FROM SmartSplitDB.Transactions as trans "
				+ "where trans.AddedTo = '"+email+"' group by trans.AddedBy) as amt "
				+ "on users.UserEmailID = amt.addBy;";
		results = sql.executeSQL(query2);
		for(Object object : results) {
			Map row = (Map) object;
			Boolean present = false;
			for (UserBalance uBal : balList) {
				if (uBal.getFriendsEmail().equalsIgnoreCase(row.get("addBy").toString()))
				{
					uBal.setBalance(uBal.getBalance() - Double.valueOf(row.get("amount").toString()));
					present = true;
					break;
				}

			}
			if(present!= true)
			{
				balList.add(new UserBalance(row.get("FirstName").toString(), row.get("LastName").toString(),
						Double.valueOf(0 - Double.valueOf((row.get("amount")).toString())), row.get("addBy").toString()));
			}
		}
		/*for(UserBalance ubal : balList)
		{
			logger.info("Bal: " + ubal.getBalance());
			logger.info("Name: " + ubal.getFriendsEmail());
		}*/
		return balList;
	}

	public UserDashboard getTotal(String userEmail)
	{
		logger.debug("IN getTotal Function");
		double totalOweingBalace = 0.0, totalOwedBalance = 0.0;
		double[] totalAmounts = null;
		UserDashboard userDash = null;
		ArrayList<UserBalance> friendsBalances = getFriendsList(userEmail);
		try {
			userDash = new UserDashboard();
			userDash.setUserBalances(friendsBalances);
			for (UserBalance li : friendsBalances) {
				if (li.getBalance() < 0) {
					totalOwedBalance = totalOwedBalance + li.getBalance();
				} else {
					totalOweingBalace = totalOweingBalace + li.getBalance();
				}
				userDash.setAmtOwe(totalOweingBalace);
				userDash.setAmtOwed(totalOwedBalance);
			}
			userDash.setUserid(userEmail);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userDash;
	}

	public Friend getTransactionsList(String userEmail, String friendsEmail) throws Exception
	{
		logger.debug("IN getTransactionsList Function");
		final String OWE = "You owe", OWED = "owes you";
		final String query = "select users.FirstName, users.LastName, users.UserEmailID, rt.tid, rt.id, rt.aby, rt.ato, rt.tot, rt.amt, rt.ttl, " +
				"rt.cat, rt.date from SmartSplitDB.users as users " +
				"inner join (select trans.idTransactions as tid, trans.GroupID as id, trans.AddedBy as aby, trans.AddedTo as ato, trans.TotalAmout as tot, trans.AmountOwe as amt, " +
				"trans.Title as ttl, trans.Category as cat, trans.Date as date from SmartSplitDB.Transactions trans where trans.AddedBy = '"+userEmail+"' and " +
				"trans.AddedTo = '"+friendsEmail+"' union select trans2.idTransactions, trans2.GroupID as id, trans2.AddedBy as aby, trans2.AddedTo as ato, trans2.TotalAmout as tot, " +
				"trans2.AmountOwe as amt, trans2.Title as ttl, trans2.Category as cat, trans2.Date from SmartSplitDB.Transactions trans2 " +
				"where trans2.AddedBy = '"+friendsEmail+"' and trans2.AddedTo = '"+userEmail+"') as rt where users.UserEmailID = rt.aby order by rt.date desc;";
		MetaTransaction trans = null;
		Double owe = 0.0, owed = 0.0;
		Friend frnd = new Friend();
		List<MetaTransaction> allTransOfFriend = new ArrayList<MetaTransaction>();

		List results = sql.executeSQL(query);

		for (Object object : results) {
			Map row = (Map)object;
			trans = new MetaTransaction();
			trans.setAddedBy(row.get("aby").toString());
			trans.setAddedTo(row.get("ato").toString());
			trans.setTotalAmount(Double.valueOf(row.get("tot").toString()));
			trans.setAmountOwe(Double.valueOf(row.get("amt").toString()));
			trans.setCategory(null != row.get("cat") ? row.get("cat").toString() : "");
			trans.setTitle(null != row.get("ttl") ? row.get("ttl").toString() : "");
			trans.setGroupid(Integer.parseInt(row.get("id").toString()));
			trans.setIdTransactions(Integer.parseInt(row.get("tid").toString()));
			trans.setFirstName(row.get("FirstName").toString());
			trans.setLastName(row.get("LastName").toString());
			allTransOfFriend.add(trans);
			/*if(trans.getAddedBy().equalsIgnoreCase(friendsEmail)) {
				owe = owe + Double.valueOf(row.get("amt").toString());
			}
			else
			{
				owed = owed + Double.valueOf(row.get("amt").toString());
				frnd.setFirstName(row.get("FirstName").toString());
				frnd.setLastName(row.get("LastName").toString());
			}*/
			/*if(trans.getAddedBy().equalsIgnoreCase(friendsEmail) || trans.getAddedTo().equalsIgnoreCase(friendsEmail)) {
				frnd.setFirstName(row.get("FirstName").toString());
				frnd.setLastName(row.get("LastName").toString());
			}*/
		}
		Users usr = new UserDaoImpl().getUser(friendsEmail);
		frnd.setFirstName(usr.getFirstName());
		frnd.setLastName(usr.getLastName());
		/*if((owed - owe) >= 0)
		{
			frnd.setWhoOwesWho(OWED);
		}
		else
		{
			frnd.setWhoOwesWho(OWE);
		}
		frnd.setTotalAmt(Math.abs(owed - owe));*/
		frnd.setTransactions(allTransOfFriend);
		return frnd;
	}
	public MetaTransaction getSingleTransaction(int transactionId) throws Exception
	{
		logger.debug("IN getSingleTransaction Function");
		final String query = "select users.FirstName, users.LastName, tr.idTransactions, tr.GroupID, tr.AddedBy, tr.AddedTo, tr.TotalAmout , tr.AmountOwe, tr.Title, tr.Category " +
				"from SmartSplitDB.users as users " +
				"inner join" +
				"(select * from SmartSplitDB.Transactions trans where trans.idTransactions = "+transactionId+") as tr " +
				"where users.UserEmailID = tr.AddedBy";
		MetaTransaction trans = null;

		List results = sql.executeSQL(query);
		Map row = (Map)results.get(0);
		trans = new MetaTransaction();
		trans.setAddedBy(row.get("AddedBy").toString());
		trans.setAddedTo(row.get("AddedTo").toString());
		trans.setTotalAmount(Double.valueOf(row.get("TotalAmout").toString()));
		trans.setAmountOwe(Double.valueOf(row.get("AmountOwe").toString()));
		trans.setCategory(null != row.get("Category") ? row.get("Category").toString() : "");
		trans.setTitle(null != row.get("Title") ? row.get("Title").toString() : "");
		trans.setGroupid(Integer.parseInt(row.get("GroupID").toString()));
		trans.setIdTransactions(Integer.parseInt(row.get("idTransactions").toString()));
		trans.setFirstName(row.get("FirstName").toString());
		trans.setLastName(row.get("LastName").toString());

		final String query2 = "select user.FirstName, user.LastName from SmartSplitDB.Users user where user.UserEmailID ='"+row.get("AddedTo").toString()+"'";

		results = sql.executeSQL(query2);
		row = (Map)results.get(0);
		trans.setOtherFirstName(row.get("FirstName").toString());
		trans.setOtherLastName(row.get("LastName").toString());
		return trans;
	}

	public UserLogin checkUserPass(String userName, String password) throws Exception
	{
		logger.debug("IN checkUserPass Function \n <-------CHECKING IF USER EXIST------->");
		final String query = "select user.FirstName, user.LastName, user.UserEmailID, user.Password from SmartSplitDB.users user " +
				"where user.UserEmailID = '"+userName+"' and  BINARY user.Password = '"+password+"'";

		UserLogin user = new UserLogin();


		List results = sql.executeSQL(query);

		if(results.size() == 1)
		{
			Map row = (Map)results.get(0);
			user.setFirstName(row.get("FirstName").toString());
			user.setLastName(row.get("LastName").toString());
			user.setEmail(row.get("UserEmailID").toString());
			user.setPassword(row.get("Password").toString());
			user.setExists("success");
		}
		else
		{
			user.setExists("failure");
		}
		return user;
	}

	public String updateTransaction(Transactions trn)
	{
		logger.debug("IN updateTransaction Function \n <-------UPDATING BILL------->");

		String query ="UPDATE SmartSplitDB.Transactions SET " +
				"Transactions.Title ='"+ trn.getTitle() +"' , " +
				"Transactions.Category = '"+ trn.getCategory() + "' , " +
				"Transactions.AddedTo = '"+ trn.getAddedTo() +"' , " +
				"TransactionS.TotalAmout = " +trn.getTotalAmount() + " , " +
				"TransactionS.AmountOwe = " + trn.getAmountOwe() + "  " +
				"WHERE Transactions.idTransactions = " + trn.getIdTransactions() + " ;";
		int result = sql.updateSQL(query);

		if (result > 0 )
			return "success";
		else
			return "fail";

	}

	public String deleteTransaction(int id)
	{
		logger.debug("IN deleteTransaction Function \n <-------DELETING BILL------->");
		String query = "DELETE FROM SmartSplitDB.Transactions where idTransactions = " + id + ";";
		int result = sql.updateSQL(query);
		if (result > 0 )
			return "success";
		else
			return "fail";
	}


}
