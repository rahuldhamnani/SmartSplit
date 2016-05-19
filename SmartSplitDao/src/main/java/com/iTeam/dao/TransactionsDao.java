package com.iTeam.dao;

import java.util.ArrayList;

import com.iTeam.common.*;

import java.util.List;

public interface TransactionsDao {

	 String addTransaction(Transactions transaction) throws Exception;
	 Friend getTransactionsList(String userEmail, String friendsEmail) throws Exception;
	 UserDashboard getTotal(String userEmail);
	 ArrayList<UserBalance> getFriendsList(String email);
	 MetaTransaction getSingleTransaction(int transactionId) throws Exception;
	 UserLogin checkUserPass(String userName, String password) throws Exception;
	 String deleteTransaction(int id);
	 String updateTransaction(Transactions trn);

}
