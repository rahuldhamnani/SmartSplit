package main.java.test;

import com.iTeam.common.UserBalance;
import com.iTeam.common.UserDashboard;
import com.iTeam.service.TransactionsService;
import com.iTeam.service.TransactionsServiceImpl;

public class TestCore {
	
	public static void main(String[] args)
	{
		
		TransactionsService ts = new TransactionsServiceImpl();
		ts.getDashboard("ashwini@gmail.com");
		 UserDashboard bal = ts.getDashboard("ashwini@gmail.com");
	        for(UserBalance val : bal.getUserBalances())
	        {
	            System.out.println("First Name: " + val.getFirstName());
	            System.out.println("Last name: " + val.getLastName());
	            System.out.println("Amount: " + val.getBalance());
	        }
	        System.out.println(bal.getAmtOwe()+"  "+bal.getAmtOwed());
	}

}
