package com.iTeam;


import com.iTeam.common.*;
import com.iTeam.service.TransactionsServiceImpl;
import junit.framework.TestCase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;


/**
 * Created by rahuldhamnani on 5/4/16.
 *
 */
public class TransactionsServiceImplTest extends TestCase {


    public void testCheckUserExistance() throws Exception
    {
        TransactionsServiceImpl tsi = new TransactionsServiceImpl();
        assertEquals("success", tsi.checkUserExistance("test@gmail.com", "test").getExists());

    }

    public void testAddBill() throws Exception {
        Transactions trn = new Transactions(1, "test@gmail.com", "Mruganka@gmail.com", 100D, 50D, "TESTCASE", "TESTCASE", new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime()));
        TransactionsServiceImpl tsi = new TransactionsServiceImpl();
        assertEquals("success", tsi.addBill(trn));
    }

    public void testUpdateTransaction ()
    {
        Transactions trn = new Transactions(1, "test@gmail.com", "Mruganka@gmail.com", 200D, 100D, "TESTCASE UPDATE", "TESTCASE UPDATE", " ");
        trn.setIdTransactions(getTransactionID());
        TransactionsServiceImpl tsi = new TransactionsServiceImpl();
        assertEquals("success",tsi.updateTransaction(trn));
    }

    public void testIndividualTransaction() throws Exception
    {
        MetaTransaction mt = new TransactionsServiceImpl().getIndividualTransaction(getTransactionID());
        assertEquals("test@gmail.com",mt.getAddedBy());
        assertEquals("Mruganka@gmail.com",mt.getAddedTo());
        assertEquals(100.00, mt.getAmountOwe());

    }

    public void testGetFriendList() throws Exception
    {
        ArrayList<UserBalance> list = new TransactionsServiceImpl().getFriendsList("test@gmail.com");
        assertEquals(100D,list.get(0).getBalance());
    }



    public void testGetDashboard() throws Exception {
        TransactionsServiceImpl tsi = new TransactionsServiceImpl();
        UserDashboard ud = tsi.getDashboard("test@gmail.com");
        System.out.println(ud.getAmtOwed());
        assertEquals(100.0,ud.getAmtOwed() );
        assertEquals(0.0, ud.getAmtOwe());
    }
    public void testFriendsTransactions() throws Exception
    {
        Friend fd = new TransactionsServiceImpl().getFriendsTransactions("test@gmail.com", "Mruganka@gmail.com");
        System.out.println(fd.getTotalAmt());
        System.out.println(fd.getWhoOwesWho());
    }
/*
    public void testSettleUp() throws Exception
    {
        Transactions trn = new Transactions(1, "Mruganka@gmail.com", "test@gmail.com", 100D, 100D, "TESTCASE UPDATE", "TESTCASE UPDATE", " ");
        TransactionsServiceImpl tsi = new TransactionsServiceImpl();
        assertEquals("success", tsi.settleUp(trn));

    }
*/

    public void testDeleteTrn() throws Exception
    {
        TransactionsServiceImpl tsi = new TransactionsServiceImpl();
        tsi.deleteTrn(getTransactionID());

    }
    public int getTransactionID()
    {
        String query = "SELECT idTransactions FROM TRANSACTIONS where AddedBy = 'test@gmail.com';";
        List results = new SQLExecutionHandler().executeSQL(query);
        Map row = (Map) results.get(0);
        int id = Integer.parseInt(row.get("idTransactions").toString());
        return id;
    }

}
