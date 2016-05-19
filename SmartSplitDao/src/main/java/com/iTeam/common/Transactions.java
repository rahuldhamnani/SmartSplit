package com.iTeam.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * created by ashwiniprabhu
 * About the class
 * Transaction class creates the blueprint for Transaction table in MySQL database.
 * It maps columns in SQL table Transaction and Object of type transaction.
 * All the variables are private and we have getter setter methods to excess them.
 *
 */

@Entity
@Table
public class Transactions implements Serializable{


	private static final long serialVersionUID = 563328389604689177L;

	@Id
	@GeneratedValue
	@Column(name = "idTransactions")
	private int idTransactions;

	@Column(name = "GroupID")
	private int groupid;

	@Column(name = "AddedBy")
	private String addedBy;

	@Column(name = "AddedTo")
	private String addedTo;


	@Column(name="TotalAmout")
	private Double totalAmount;


	@Column(name="AmountOwe")
	private Double amountOwe;

	@Column(name="Title")
	private String title;

	@Column(name="Category")
	private String category;

	@Column(name="Date")
	private String date;

	public Transactions()
	{}

	public Transactions(int groupid, String addedBy, String addedTo, Double totalAmount,
						Double amountOwe, String title, String category, String date) {
		super();
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

	public int getgroupId() {
		return groupid;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public String getAddedTo() {
		return addedTo;
	}

	public void setAddedTo(String addedTo) {
		this.addedTo = addedTo;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getAmountOwe() {
		return amountOwe;
	}

	public void setAmountOwe(Double amountOwe) {
		this.amountOwe = amountOwe;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setIdTransactions(int idTransactions) {
		this.idTransactions = idTransactions;
	}
}
