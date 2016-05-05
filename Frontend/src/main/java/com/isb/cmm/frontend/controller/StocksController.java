package com.isb.cmm.frontend.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StocksController {

	@RequestMapping(method = GET)
	public List<Stock> getTickerList() {
		List<Stock> result = new ArrayList<>();

		result.add(createStock('$', "GOOGL", 9324.12, 12, +1));
		result.add(createStock('$', "AAPL", 5374.23, 50, -1));
		result.add(createStock('$', "FB", 4623.89, 42, 0));
		result.add(createStock('€', "SAN", 2743.18, 674, +1));
		return result;
	}

	private Stock createStock(char currency, String ticker, double value, int shares, int recommendation) {
		Stock stock = new Stock();
		stock.setCurrency(currency);
		stock.setTicker(ticker);
		stock.setValue(value);
		stock.setShares(shares);
		stock.setRecommendation(recommendation);

		return stock;
	}

}
