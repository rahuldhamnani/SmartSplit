package com.iTeam.service;


import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

import com.iTeam.dao.TransactionsDaoImpl;
import org.springframework.transaction.annotation.Transactional;

import com.iTeam.common.*;
import com.iTeam.dao.TransactionsDao;


@Transactional
public class TransactionsServiceImpl implements TransactionsService
{

	private TransactionsDao transactionDao;

	/* For Testing purpose only */
	//private TransactionsDao transactionDao = new TransactionsDaoImpl();

	public TransactionsDao getTransactionDao() {
		return transactionDao;
	}

	public void setTransactionDao(TransactionsDao transactionDao) {
		this.transactionDao = transactionDao;
	}


	public ArrayList<UserBalance> getFriendsList(String userEmail)
	{
		return transactionDao.getFriendsList(userEmail);
	}

	public UserDashboard getDashboard(String userEmail)
	{
		double totalOweingBalace = 0.0, totalOwedBalance = 0.0;
		double[] totalAmounts = null;
		UserDashboard userDash = null;
		DecimalFormat df2 = new DecimalFormat("00.00000");
		//transactionDao = new TransactionsDaoImpl();
		ArrayList<UserBalance> friendsBalances = transactionDao.getFriendsList(userEmail);
		try {
			userDash = new UserDashboard();
			userDash.setUserBalances(friendsBalances);
			for (UserBalance li : friendsBalances) {
				if (li.getBalance() > 0) {
					totalOwedBalance = totalOwedBalance + li.getBalance();
				} else {
					totalOweingBalace = totalOweingBalace + li.getBalance();
				}
				//li.setBalance(Double.valueOf(df2.format(Math.abs(li.getBalance()))));
				li.setBalance(Double.valueOf(df2.format(li.getBalance())));
			}
			userDash.setAmtOwe(Double.valueOf(df2.format(Math.abs(totalOweingBalace))));
			userDash.setAmtOwed(Double.valueOf(df2.format(Math.abs(totalOwedBalance))));
			userDash.setUserid(userEmail);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userDash;
		//transactionDao = new TransactionsDaoImpl();
		//return transactionDao.getTotal(userEmail);
	}
	public Friend getFriendsTransactions(String userEmail, String friendsEmail) throws Exception
	{
		//TransactionsDaoImpl trdo = new TransactionsDaoImpl();
		Double owe = 0.0, owed = 0.0;
		final String OWE = "You owe", OWED = "owes you";
		DecimalFormat df2 = new DecimalFormat("00.00000");
		//transactionDao = new TransactionsDaoImpl();
		Friend frnd = transactionDao.getTransactionsList(userEmail, friendsEmail);
		for(MetaTransaction trans : frnd.getTransactions())
		{
			if(trans.getAddedBy().equalsIgnoreCase(friendsEmail)) {
				owe = owe + trans.getAmountOwe();
			}
			else
			{
				owed = owed + trans.getAmountOwe();
			}
		}
		if((owed - owe) >= 0)
		{
			frnd.setWhoOwesWho(OWED);
		}
		else
		{
			frnd.setWhoOwesWho(OWE);
		}
		frnd.setTotalAmt(Double.valueOf(df2.format(Math.abs(owed - owe))));
		return frnd;
		//return transactionDao.getTransactionsList(userEmail, friendsEmail);
	}

	public MetaTransaction getIndividualTransaction(int transactionId) throws Exception
	{
		return transactionDao.getSingleTransaction(transactionId);

	}

	public UserLogin checkUserExistance(String uName, String pWord) throws Exception
	{
		return transactionDao.checkUserPass(uName, pWord);
	}

	public String addBill(Transactions transaction) throws Exception
	{
		transaction.setDate(getCurrentDate());
		return transactionDao.addTransaction(transaction);
	}

	public String updateTransaction(Transactions trn)
	{
		trn.setDate(getCurrentDate());
		return transactionDao.updateTransaction(trn);
	}

	public String settleUp ( Transactions trn) throws Exception
	{
		trn.setTitle("SETTLE UP");
		trn.setCategory("SETTLE UP");
		trn.setDate(getCurrentDate());
		return transactionDao.addTransaction(trn );

	}

	public String deleteTrn ( int trn) throws Exception
	{
		return transactionDao.deleteTransaction(trn);
	}


	public String getCurrentDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		return dateFormat.format(date);

	}

	public Users getUser(String email) throws Exception
	{
		return new UserServiceImpl().getUser(email);

	}

	public String findUserEmailID (String fName, String lName) throws Exception
	{

		return new UserServiceImpl().findUserEmailID(fName,lName);
	}
	public String updateUser(Users usr) throws Exception
	{
		return new UserServiceImpl().updateUser(usr);
	}

}
