package com.iTeam.dao;

import com.iTeam.common.*;
import com.iTeam.persistence.HibernateUtil;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.event.MergeEvent;
import org.hibernate.mapping.Array;


/**
 * Created by rahuldhamnani on 4/17/16.
 *
 *
 * Methods  ---    explanation
 * addGroup - to create a new group into Database
 * nameToGroupID - to convert Group name to GroupID
 * ExecuteSQL - to execute all the sql queries
 * getGroupDetails - to get all the group details
 * addGroupMember - to add a user into a group
 * checkExistence - to check if the user is already in a group
 */
public class GroupDaoImpl implements GroupsDao
{

    private static Logger logger = Logger.getLogger("UserDao");

    public String addGroup(String name, String createdBy, String dateCreated) throws Exception {

        logger.debug("Adding new Group");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Groups grp = new Groups();
        grp.setName(name);
        grp.setCreatedBy(createdBy);
        grp.setDateCreated(dateCreated);
        session.save(grp);

        // Execute the SQL statement
        session.getTransaction().commit();
        return "success";
    }

    public List executeSQL(String query)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        SQLQuery sqlquery = session.createSQLQuery(query);
        sqlquery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        return sqlquery.list();
    }

    public ArrayList<Groups> getGroupDetails(String name) throws Exception
    {
            final String query ="select groupid, name, CreatedBy, DateCreated from SmartSplitDB.Groups where name ='" + name + "';";
            List results = executeSQL(query);
            ArrayList<Groups> grp = new ArrayList<Groups>();
            for(Object object : results)
            {
                Map row = (Map)object;
                grp.add( new Groups(Integer.parseInt(row.get("GroupID").toString()),
                        row.get("Name").toString(),
                        row.get("createBy").toString(),
                        row.get("DateCreated").toString()));

            }
            return grp;
    }
   public String addGroupMember(ArrayList<GroupMembers> addList) //throws Exception
   {
       //System.out.println("Inside usergroup");
       for(GroupMembers i : addList)
       {
          // System.out.println("Inside For LOOP of usergroup");
           int groupID = i.getGroupID();
           String email = i.getUserID();

           if (checkExistence(groupID, email) == "success")
           {
               Session session = HibernateUtil.getSessionFactory().openSession();
               session.beginTransaction();
               GroupMembers ugrp = new GroupMembers();
               ugrp.setGroupID(groupID);
               ugrp.setUserID(email);
               session.save(ugrp);
               session.getTransaction().commit();
              // System.out.println("Inside if of usergroup " + groupID + " " + email);
           }
           else
           {
               return "failure";

           }

       }
       return "success";
   }


    public int nameToGroupID (String name)
    {
        String query = "select groupid from SmartSplitDB.Groups where name = '" + name + "';";
        List results = executeSQL(query);
        Map row = (Map) results.get(0);
        int id = Integer.parseInt(row.get("groupid").toString());
        return id ;
    }

    public String checkExistence (int groupID, String email)
    {
        String query = "select count(*) as row_count from SmartSplitDB.GroupMembers " +
                "where UserID = '" + email + "' " +
                "and GroupId = "+ groupID +";";

        List results = executeSQL(query);
        Map row = (Map) results.get(0);
        if (Integer.parseInt(row.get("row_count").toString()) == 0)
        {

           return "success";
        }
        return  "failure";
    }

    public ArrayList<MetaTransaction> getGroupTransactions(int grpid, String userEmailid)
    {

        MetaTransaction grpTrans;
        ArrayList<MetaTransaction> grpTransList = new ArrayList<>();
        String query = "SELECT FirstName, LastName, idTransactions, GroupID, AddedBy, AddedTo, TotalAmout, AmountOwe, Title, Category, Date FROM SmartSplitDB.Transactions " +
                " where GroupID = " +grpid +
                " and AddedBy = UserEmailID " +
                " and (AddedBy = '" + userEmailid + "' or AddedTo ='"+ userEmailid+"' );";

        List list = executeSQL(query);
        for (Object object : list) {
            Map row = (Map) object;
            grpTrans = new MetaTransaction();
            grpTrans.setAddedBy(row.get("AddedBy").toString());
            grpTrans.setAddedTo(row.get("AddedTo").toString());
            grpTrans.setTotalAmount(Double.valueOf(row.get("TotalAmout").toString()));
            grpTrans.setAmountOwe(Double.valueOf(row.get("AmountOwe").toString()));
            grpTrans.setCategory(null != row.get("Category") ? row.get("Category").toString() : "");
            grpTrans.setTitle(null != row.get("Title") ? row.get("Title").toString() : "");
            grpTrans.setGroupid(Integer.parseInt(row.get("GroupID").toString()));
            grpTrans.setIdTransactions(Integer.parseInt(row.get("idTransactions").toString()));
            grpTrans.setFirstName(row.get("FirstName").toString());
            grpTrans.setLastName(row.get("LastName").toString());
            grpTransList.add(grpTrans);
        }

        return grpTransList;
    }

}
