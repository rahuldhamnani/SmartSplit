package com.iTeam;

import com.iTeam.common.Users;
import com.iTeam.dao.UserDaoImpl;
import com.iTeam.service.UserServiceImpl;
import junit.framework.TestCase;

/**
 * Created by rahuldhamnani on 5/5/16.
 *
 *
 */
public class UserServiceImplTest extends TestCase
{
    private Users usr = new Users("TestAddUser@gmail.com", "TestAddUser", "TestAddUser", "Test");
    private UserServiceImpl usi = new UserServiceImpl();

    public void testAddUser() throws Exception {
        assertEquals("success",usi.addUser(usr));
    }

    public void testUpdateUser() throws Exception
    {
        usr.setFirstName("TESTCASEUPDATE");
        usr.setLastName("TESTCASEUPDATE");
        usr.setPassword("TESTCASEUPDATE");
        assertEquals("success", usi.updateUser(usr));
    }

    public void testGetUser() throws Exception
    {
        assertEquals("TESTCASEUPDATE", usi.getUser("TestAddUser@gmail.com").getFirstName());
    }

    public void testFindUserEmailID() throws Exception
    {
        assertEquals("TestAddUser@gmail.com".toLowerCase(), usi.findUserEmailID("TESTCASEUPDATE", "TESTCASEUPDATE"));
    }

    public void testDeleteUser() throws Exception
    {
        UserDaoImpl udi = new UserDaoImpl();
        assertEquals("success", udi.deleteUser("testadduser@gmail.com"));
    }

}
