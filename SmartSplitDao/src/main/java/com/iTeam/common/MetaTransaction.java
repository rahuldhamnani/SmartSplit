package com.iTeam.common;

/**
 * Created by ashwinipprabhu
 * About the class
 * MetaTransaction blueprint created to handle json objects of type transaction specially for dashboard page.
 * All the variables are private and we have getter setters to access them.
 */
public class MetaTransaction {
    private int idTransactions;
    private int groupid;
    private String addedBy;
    private String addedTo;
    private Double totalAmount;
    private Double amountOwe;
    private String title;
    private String category;
    private String date;
    private String firstName;
    private String lastName;
    private String otherFirstName;
    private String otherLastName;

    public MetaTransaction() {
    }

    public MetaTransaction(int idTransactions, int groupid, String addedBy, String addedTo, Double totalAmount, Double amountOwe, String title, String category, String date) {
        this.idTransactions = idTransactions;
        this.groupid = groupid;
        this.addedBy = addedBy;
        this.addedTo = addedTo;
        this.totalAmount = totalAmount;
        this.amountOwe = amountOwe;
        this.title = title;
        this.category = category;
        this.date = date;
    }

    public int getIdTransactions() {
        return idTransactions;
    }

    public int getGroupid() {
        return groupid;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public String getAddedTo() {
        return addedTo;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Double getAmountOwe() {
        return amountOwe;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public void setIdTransactions(int idTransactions) {
        this.idTransactions = idTransactions;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public void setAddedTo(String addedTo) {
        this.addedTo = addedTo;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setAmountOwe(Double amountOwe) {
        this.amountOwe = amountOwe;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherFirstName() {
        return otherFirstName;
    }

    public void setOtherFirstName(String otherFirstName) {
        this.otherFirstName = otherFirstName;
    }

    public String getOtherLastName() {
        return otherLastName;
    }

    public void setOtherLastName(String otherLastName) {
        this.otherLastName = otherLastName;
    }
}