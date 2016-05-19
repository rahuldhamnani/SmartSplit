package com.iTeam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.iTeam.common.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.iTeam.dao.GroupDaoImpl;
import com.iTeam.dao.TransactionsDaoImpl;
import com.iTeam.dao.UserDaoImpl;
import com.iTeam.persistence.HibernateUtil;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        final Logger logger = Logger.getLogger("App");
        logger.info("Maven + Hibernate + MySQL");
        UserDaoImpl udi = new UserDaoImpl();
        udi.findEmailID("Mruganka", "LONDHE");
      //  user();
        //deltrn(27);


    }

    /*public static void deltrn ( int id)
    {
        TransactionsDaoImpl tp = new TransactionsDaoImpl();
        tp.deleteTransaction(id);
    }*/

   /* public static void user()
    {
        UserDaoImpl udi = new UserDaoImpl();
        /*Users usr = new Users("testadduser@gmail.com","aabbccdd" ,"aabbccdd", "Password");
       try {
           udi.addUser(usr);
       }
        catch (Exception e)
        {
            System.out.println(e);
        }
        udi.updateUser("test@gmail.com", "helloooooo", 'p');
        //Users testUser = udi.getUser("test@gmail.com");
        //System.out.println(testUser.getFirstName());
    }*/
/*
    public static void transaction(Logger logger)
    {
        try {
            TransactionsDaoImpl trans = new TransactionsDaoImpl();
            trans.addTransaction(1, "ashwini@gmail.com", "Mruganka@gmail.com", 100D, 50D, "Bread", "Groceries", new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime()));
            Friend balList = trans.getTransactionsList("ashwini@gmail.com","Mruganka@gmail.com");
            /*for (UserBalance val : balList) {
                logger.info("First Name: " + val.getFirstName());
                logger.info(", Last name: " + val.getLastName());
                logger.info(", Amount: " + val.getBalance());
            }*/ /*
        }
        catch (Exception e)
        {

        }
    }
    public static void group()
    {
        GroupDaoImpl grp = new GroupDaoImpl();
        ArrayList<GroupMembers> test = new ArrayList<>();

        test.add(new GroupMembers(grp.nameToGroupID("Friday dinner"), "ashwini@gmail.com"));
        test.add(new GroupMembers(grp.nameToGroupID("Friday dinner"), "Mruganka@gmail.com"));

        String status = grp.addGroupMember(test);
        System.out.println("Add Status "+ status);

    }*/

}
