package com.stock.data;

public class Corporation {

	
	private String corporationName;
	
	private Double stockValue;
	
	public Corporation(String id){
		this.corporationName = id;
	}

	public String getCorporationName() {
		return corporationName;
	}

	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}

	public Double getStockValue() {
		return stockValue;
	}

	public void setStockValue(Double stockValue) {
		this.stockValue = stockValue;
	}
	
	
}
