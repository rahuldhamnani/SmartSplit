package com.iTeam.service;

import com.iTeam.common.UserLogin;
import com.iTeam.dao.UserDaoImpl;
import com.iTeam.dao.UsersDao;
import com.iTeam.common.Users;
import com.iTeam.dao.UserDaoImpl;

/**
 * Created by rahuldhamnani on 4/21/16.
 *
 *
 */
public class UserServiceImpl implements UserService{

    private UsersDao userDao;

    //For Testing Purpose only
    //private UsersDao userDao = new UserDaoImpl();

    public UsersDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UsersDao userDao) {
        this.userDao = userDao;
    }

    public String addUser(Users user) throws Exception
    {
        user.setEmail(user.getEmail().toLowerCase());
        return userDao.addUser(user);
    }

    public String updateUser(Users usr) throws Exception
    {

        return new UserDaoImpl().updateUser(usr);
    }
    public Users getUser(String emailID) throws Exception
    {
        return new UserDaoImpl().getUser(emailID);
    }

    public String findUserEmailID(String fName, String lName) throws Exception
    {
        return new UserDaoImpl().findEmailID(fName, lName);
    }


}
