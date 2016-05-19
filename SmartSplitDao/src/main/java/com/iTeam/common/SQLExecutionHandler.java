package com.iTeam.common;

import com.iTeam.persistence.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by rahuldhamnani
 *
 * About the class -
 * SQLExecutionHandler class handles all the query execution requested.
 * Hibernate framework has been used to perform database task.
 *
 * Method    -     Description
 * executeSQL - The method take SQL query in form of string and run it on database. The result is returned in
 *              from of List.
 *
 * updateSQL - The method take SQL query (update/delete) in form of string and run it on database. An integer
 *             indicating success (1) or failure (0) is returned.
 *
 * addSQL - The method takes Object as input and depending upon what kind of object it is the entry in
 *          database is made eg: User table or Transaction table.
 *
 */
public class SQLExecutionHandler {

    public List executeSQL(String query)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        SQLQuery sqlquery = session.createSQLQuery(query);
        sqlquery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = sqlquery.list();
        return results;
    }

    public int updateSQL(String query)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        SQLQuery sqlquery = session.createSQLQuery(query);
        int result = sqlquery.executeUpdate();
        session.getTransaction().commit();
        return result;
    }

    public String addSQL(Object object)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        if (object instanceof Users)
        {
            Users newObject = (Users) object;
            session.save(newObject);
        }
        else if(object instanceof Transactions)
        {
            Transactions newObject = (Transactions) object;
            session.save(newObject);
        }

        session.getTransaction().commit();

        return "success";
    }

}
