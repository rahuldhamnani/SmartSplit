package com.iTeam;

import com.iTeam.common.*;
import com.iTeam.dao.*;
import junit.framework.TestCase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by rahuldhamnani on 4/8/16.
 *
 *
 */
public class TransactionsDaoImplTest extends TestCase {
    SQLExecutionHandler sql = new SQLExecutionHandler();

    public void testAddTransaction() throws Exception {
        Transactions trn = new Transactions(1, "test@gmail.com", "Mruganka@gmail.com", 100D, 50D, "TESTCASE", "TESTCASE", new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime()));
        trn.setIdTransactions(100);
        assertEquals("success", new TransactionsDaoImpl().addTransaction(trn));
    }
    public int getTransactionID()
    {
        String query = "SELECT idTransactions FROM TRANSACTIONS where AddedBy = 'test@gmail.com';";
        List results = sql.executeSQL(query);
        Map row = (Map) results.get(0);
        int id = Integer.parseInt(row.get("idTransactions").toString());
        return id;
    }


    public void testCheckUserPass() throws Exception
    {
        TransactionsDaoImpl trans = new TransactionsDaoImpl();
        assertEquals("success", trans.checkUserPass("test@gmail.com", "Test").getExists());
    }

    public void testUpdateTransaction() throws Exception
    {
        Transactions trn = new Transactions(1, "test@gmail.com", "Mruganka@gmail.com", 200D, 100D, "TESTCASE UPDATE", "TESTCASE UPDATE", new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime()));
        trn.setIdTransactions(getTransactionID());
        assertEquals("success", new TransactionsDaoImpl().updateTransaction(trn));
    }

    public void testGetSingleTransaction() throws Exception
    {
        MetaTransaction mt = new TransactionsDaoImpl().getSingleTransaction(getTransactionID());
        assertNotNull(mt);
    }

    public void testGetTransactionsList() throws Exception
    {
        Friend frd =  new TransactionsDaoImpl().getTransactionsList("test@gmail.com", "Mruganka@gmail.com");
        System.out.println(frd.getTransactions().get(0).toString());
        assertEquals("Test",frd.getTransactions().get(0).getFirstName());
       // assertEquals("Mruganka",frd.getTransactions().get(0).getOtherFirstName());
    }

    public void testGetFriendsList() throws Exception
    {
        ArrayList<UserBalance> ballist = new TransactionsDaoImpl().getFriendsList("test@gmail.com");
        assertEquals(100D,ballist.get(0).getBalance());
    }


    public void testDeleteTransaction() throws Exception
    {
        assertEquals("success", new TransactionsDaoImpl().deleteTransaction(getTransactionID()));
    }

}