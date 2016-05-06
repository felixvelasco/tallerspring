package com.stock.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;


@Component
public class StockRateInformation {
	
	public Corporation getActualStock(String id){
		
		Corporation corp = new Corporation(id);
		Stock stockValue = null;
		try {
			stockValue = YahooFinance.get(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		corp.setStockValue(stockValue.getQuote().getPreviousClose().doubleValue());
		return corp;
	}
	
//	public Corporation getInTimeStock(String id, Date date){
//		Corporation corp = new Corporation(id);
//		Stock stockValue = null;
//		try {
//			stockValue = YahooFinance.get(id);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		double stockValueIntime = stockValue.;
//		return corp;
//	}
	
	public List<Double> getStockRateHistory(String id, Calendar dateBegin, Calendar dateEnd){
		Stock stockValue = null;
		ArrayList<Double>  stockRateList = new ArrayList<Double>();
		try {
			stockValue = YahooFinance.get(id);
		
			List<HistoricalQuote> history  = stockValue.getHistory(dateBegin,dateEnd);
			for (HistoricalQuote historicalQuote : history) {
				stockRateList.add(historicalQuote.getClose().doubleValue());
			}
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stockRateList;
	}
}
