package com.iTeam.common;

import java.util.ArrayList;

/**
 * Created by ashwinipprabhu
 * About the class
 * UserBalance blueprint created to handle json objects of type UserBalance specially for user dashboard page.
 * All the variables are private and we have getter setters to access them.
 */

public class UserDashboard {

    private ArrayList<UserBalance> userBalances;
    private double amtOwed;
    private double amtOwe;
    private String userid;

    public UserDashboard() {
    }

    public UserDashboard(ArrayList<UserBalance> userBalances, double amtOwed, double amtOwe) {
        this.userBalances = userBalances;
        this.amtOwed = amtOwed;
        this.amtOwe = amtOwe;
    }

    public ArrayList<UserBalance> getUserBalances() {
        return userBalances;
    }

    public double getAmtOwed() {
        return amtOwed;
    }

    public double getAmtOwe() {
        return amtOwe;
    }

    public void setUserBalances(ArrayList<UserBalance> userBalances) {
        this.userBalances = userBalances;
    }

    public void setAmtOwed(double amtOwed) {
        this.amtOwed = amtOwed;
    }

    public void setAmtOwe(double amtOwe) {
        this.amtOwe = amtOwe;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String user) {
        this.userid = user;
    }
}
