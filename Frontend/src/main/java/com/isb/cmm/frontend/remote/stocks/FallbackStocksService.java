package com.isb.cmm.frontend.remote.stocks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FallbackStocksService implements StocksService {

	@Override
	public List<TheStock> getTickerList() {
		List<TheStock> result = new ArrayList<>();

		result.add(createStock('$', "GOOGL", 9324.12, 12, +1));
		result.add(createStock('$', "AAPL", 5374.23, 50, -1));
		result.add(createStock('$', "FB", 4623.89, 42, 0));
		result.add(createStock('€', "SAN", 2743.18, 674, +1));
		return result;
	}
	private TheStock createStock(char currency, String ticker, double value, int shares, int recommendation) {
		TheStock stock = new TheStock();
		stock.setCurrency(currency);
		stock.setTicker(ticker);
		stock.setValue(value);
		stock.setShares(shares);
		stock.setRecommendation(recommendation);

		return stock;
	}
}