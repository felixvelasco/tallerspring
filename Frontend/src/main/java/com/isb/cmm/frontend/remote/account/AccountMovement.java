package com.isb.cmm.frontend.remote.account;

import java.util.Date;

public class AccountMovement {
	
	private double amount;
	private Date date;
	private String concept;

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the concept
	 */
	public String getConcept() {
		return concept;
	}

	/**
	 * @param concept
	 *            the concept to set
	 */
	public void setConcept(String concept) {
		this.concept = concept;
	}
}
