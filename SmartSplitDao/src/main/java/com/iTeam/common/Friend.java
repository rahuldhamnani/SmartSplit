package com.iTeam.common;

import java.util.List;

/**
 * Created by ashwinipprabhu on 4/17/16.
 *
 * whoOwesWho - OWED mean green i,e I have given money, OWE mean red i,e I have taken money!
 */
public class Friend
{
    private List<MetaTransaction> transactions;
    private String firstName;
    private String lastName;
    private double totalAmt;
    private String whoOwesWho;

    public Friend() {
    }

    public Friend(List<MetaTransaction> transactions, String firstName, String lastName, double totalAmt, String whoOwesWho) {
        this.transactions = transactions;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalAmt = totalAmt;
        this.whoOwesWho = whoOwesWho;
    }

    public List<MetaTransaction> getTransactions() {
        return transactions;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getTotalAmt() {
        return totalAmt;
    }

    public String getWhoOwesWho() {
        return whoOwesWho;
    }

    public void setTransactions(List<MetaTransaction> transactions) {
        this.transactions = transactions;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTotalAmt(double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public void setWhoOwesWho(String whoOwesWho) {
        this.whoOwesWho = whoOwesWho;
    }
}
