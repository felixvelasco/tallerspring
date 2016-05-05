package com.taller.valores.remote.stock;

import org.springframework.stereotype.Component;

@Component
public class FallbackStocksService implements StocksService {

	@Override
	public double getStockRate(String stockId) {
		
		return -1;
	}
	

}
