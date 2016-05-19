package com.iTeam.service;

import java.util.ArrayList;

import com.iTeam.common.*;


public interface TransactionsService
{

	String addBill(Transactions transaction) throws Exception;
	ArrayList<UserBalance> getFriendsList(String userEmail);
	UserDashboard getDashboard(String userEmail);
	Friend getFriendsTransactions(String userEmail, String friendsEmail) throws Exception;
	MetaTransaction getIndividualTransaction(int transactionId) throws Exception;
	UserLogin checkUserExistance(String userName, String password) throws Exception;
	String settleUp(Transactions trn) throws Exception;
	String deleteTrn(int trn) throws Exception;
	Users getUser(String email) throws Exception;
	String updateTransaction(Transactions trn) throws Exception;
	String findUserEmailID(String fName, String lName) throws Exception;
	String updateUser(Users usr) throws Exception;
}
