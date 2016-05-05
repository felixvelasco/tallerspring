package com.isb.cmm.cuentas.repository;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movement {

	@Id
	@GeneratedValue
	private Long movementId;
	
	private double amount;
	private Date date;
	private String concept;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="accountId")
	@JsonIgnore
	private Account account;

	/**
	 * @return the movementId
	 */
	public Long getMovementId() {
		return movementId;
	}

	/**
	 * @param movementId the movementId to set
	 */
	public void setMovementId(Long movementId) {
		this.movementId = movementId;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
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
	 * @param date the date to set
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
	 * @param concept the concept to set
	 */
	public void setConcept(String concept) {
		this.concept = concept;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
}
