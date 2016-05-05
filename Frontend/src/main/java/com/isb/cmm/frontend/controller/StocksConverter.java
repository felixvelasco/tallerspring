package com.isb.cmm.frontend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.isb.cmm.frontend.remote.stocks.TheStock;

@Component
public class StocksConverter {

	public List<Stock> convert(List<TheStock> tickerList) 
	{
		List<Stock>  lS = new ArrayList<Stock>();
		for (TheStock thestock : tickerList) {
			lS.add(convertI (thestock));
		}		
		return lS;
	}

	private Stock convertI(TheStock thestock) 
	{
		Stock stt = new Stock();
		stt.setCurrency(thestock.getCurrency());
		stt.setRecommendation(thestock.getRecommendation());
		stt.setShares(thestock.getShares());
		stt.setTicker(thestock.getTicker());
		stt.setValue(thestock.getValue());
		return stt;
	}


}
