package com.isb.cmm.cuentas.repository;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private Long id;
	
	private double balance;
	private Long userId;
	
	@OneToMany(mappedBy="account")
	private List<Movement> movements;

	/**
	 * @return the id
	 */
	public Long getid() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setid(Long id) {
		this.id = id;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param saldo the balance to set
	 */
	public void setSaldo(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the movements
	 */
	public List<Movement> getMovements() {
		return movements;
	}

	/**
	 * @param movements the movements to set
	 */
	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}
}
