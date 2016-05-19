package com.iTeam;


import com.iTeam.common.*;
import com.iTeam.dao.*;
import junit.framework.TestCase;

/**
 * Created by rahuldhamnani on 4/9/16.
 *
 */
public class UserDaoImplTest extends TestCase {
    private Users usr = new Users("TestAddUser@gmail.com", "TestAddUser", "TestAddUser", "Test");

    public void testAddUser() throws Exception
    {
        UserDaoImpl udi = new UserDaoImpl();
        assertEquals("success", udi.addUser(usr));
    }

    public void testGetUser() throws Exception
    {
        UserDaoImpl udi = new UserDaoImpl();
        Users testUser = udi.getUser("TestAddUser@gmail.com");
        assertTrue(testUser.getEmail().equals("TestAddUser@gmail.com"));
    }

    public void testUpdateUser() throws Exception
    {
        UserDaoImpl udi = new UserDaoImpl();
        usr.setFirstName("Test User Update");
        usr.setLastName("Test User Update");
        usr.setPassword("PasswordUpdate");
        assertEquals("success", udi.updateUser(usr));
    }

    public void testDeleteUser() throws Exception
    {
        UserDaoImpl udi = new UserDaoImpl();
        assertEquals("success", udi.deleteUser("TestAddUser@gmail.com"));
    }

}