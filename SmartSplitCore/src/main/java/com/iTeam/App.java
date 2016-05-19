package com.iTeam;

import java.util.ArrayList;
import java.util.List;

import com.iTeam.common.*;
import com.iTeam.service.TransactionsService;
import com.iTeam.service.TransactionsServiceImpl;
import com.iTeam.service.UserServiceImpl;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {
        TransactionsService tranServ = new TransactionsServiceImpl();
        UserServiceImpl userServ = new UserServiceImpl();
        // ArrayList<UserBalance> balList = tranServ.getFriendsList("ashwini@gmail.com");

       /* UserDashboard bal = tranServ.getDashboard("ashwini@gmail.com");
        for(UserBalance val : bal.getUserBalances())
        {
            System.out.println("First Name: " + val.getFirstName());
            System.out.println("Last name: " + val.getLastName());
            System.out.println("email: " + val.getFriendsEmail());
        }
        System.out.println(bal.getAmtOwe()+"  "+bal.getAmtOwed());
       /* try {
            Friend frn = tranServ.getFriendsTransactions("ashwini@gmail.com", "Mruganka@gmail.com");
            for(MetaTransaction val : frn.getTransactions())
            {
                System.out.println("Title: " + val.getLastName());
                System.out.println("Category: " + val.getCategory());
                System.out.println("Amount: " + val.getAmountOwe());
            }
            System.out.println(frn.getWhoOwesWho() +" "+frn.getTotalAmt());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }*/
        try {
            /*Users us = new Users();
            us.setFirstName("Sonam");
            us.setLastName("Lodhi");
            us.setEmail("sonam@gmail.com");
            us.setPassword("sonam");
            String res = userServ.addUser(us);
            System.out.println("Result "+res);*/
            UserLogin result = tranServ.checkUserExistance("ashwini@gmail.com", "Test");

            System.out.println("result: "+result.getExists());
            System.out.println("result: "+result.getFirstName());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
