package com.isb.cmm.frontend.controller;

public class Stock {
	private String ticker;
	private double value;
	private int shares;
	private char currency;
	private int recommendation;

	/**
	 * @return the ticker
	 */
	public String getTicker() {
		return ticker;
	}

	/**
	 * @param ticker
	 *            the ticker to set
	 */
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * @return the currency
	 */
	public char getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(char currency) {
		this.currency = currency;
	}

	/**
	 * @return the shares
	 */
	public int getShares() {
		return shares;
	}

	/**
	 * @param shares the shares to set
	 */
	public void setShares(int shares) {
		this.shares = shares;
	}

	/**
	 * @return the recommendation
	 */
	public int getRecommendation() {
		return recommendation;
	}

	/**
	 * @param recommendation the recommendation to set
	 */
	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}
}
