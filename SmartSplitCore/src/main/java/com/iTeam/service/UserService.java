package com.iTeam.service;

import com.iTeam.common.UserLogin;
import com.iTeam.common.Users;
import com.iTeam.dao.UsersDao;

/**
 * Created by ashwinipprabhu on 4/21/16.
 */
public interface UserService {
    String addUser(Users user) throws Exception;
    String updateUser(Users usr) throws Exception;
    Users getUser(String emailID) throws Exception;
    String findUserEmailID(String fName, String lName) throws Exception;
}
