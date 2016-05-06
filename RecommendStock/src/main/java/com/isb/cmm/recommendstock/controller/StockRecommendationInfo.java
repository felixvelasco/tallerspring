package com.isb.cmm.recommendstock.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isb.cmm.recommendstock.remote.stock.StockService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class StockRecommendationInfo {
	
	@Autowired
	private StockService stockService;
	
	//Usamos Value para recoger el parametro days de la clase de configuracion StockConf
	@Value("${stocks.days}")
	private int daysCount;
	
	@RequestMapping(method = RequestMethod.GET, path = "/recommendStock/{value}")
	public String getRecommendation(@PathVariable("value") String value) {
		Calendar cal = Calendar.getInstance();
		Date currentDate = cal.getTime();
		cal.add(Calendar.DATE, -daysCount);
		Date dateBefore30Days = cal.getTime();
		
		List<Double> stockHist = stockService.getStockRateHistory(value, dateBefore30Days, currentDate);
		Double firstValue = stockHist.get(0);
		Double lastValue = stockHist.get(stockHist.size()-1);
		
		if ((lastValue - firstValue) < 0){
			return "Buy";
		}
		else{
			return "Sell";
		}
	}

}
