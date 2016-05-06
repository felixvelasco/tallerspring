package com.stock.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stock.data.Corporation;
import com.stock.data.StockRateInformation;

@RestController
public class StockController {
	
	@Autowired
	StockRateInformation stockRateInformation;

	@RequestMapping(method = RequestMethod.GET, path = "/stockrate/{id}")
	public double getStockRate(@PathVariable("id") String id) {
		
		Corporation corp = stockRateInformation.getActualStock(id);
		return corp.getStockValue();
	}
	
//	@RequestMapping(method = RequestMethod.GET, path = "/stockrate/{id}/{date}")
//	public double getStockRateInTime(@PathVariable("id") String id, Date date) {
//		Corporation corp = stockRateInformation.getInTimeStock(id,date);
//		return corp.getStockValue();
//	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/stockrate/{id}/{dateBegin}/{dateEnd}")
	public List<Double> getStockRateHistory(@PathVariable("id") String id,@PathVariable("dateBegin") String dateBegin, @PathVariable("dateEnd")String dateEnd) {
		
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Calendar calBegin  = Calendar.getInstance();
		try {
			calBegin.setTime(df.parse(dateBegin));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar calEnd  = Calendar.getInstance();
		try {
			calEnd.setTime(df.parse(dateEnd));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stockRateInformation.getStockRateHistory(id,calBegin,calEnd);
	}
	
}
