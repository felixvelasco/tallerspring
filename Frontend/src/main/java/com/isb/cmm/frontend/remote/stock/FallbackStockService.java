package com.isb.cmm.frontend.remote.stock;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FallbackStockService implements StockService {

	private static final double[] PRECIO = new double[] { 1.0, 2.0,3.0};


	@Override
	public double getValue(String id) {
		Random r = new Random();
		return PRECIO[r.nextInt(PRECIO.length)];
	}


}
