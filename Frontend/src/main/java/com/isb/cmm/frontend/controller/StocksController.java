package com.isb.cmm.frontend.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isb.cmm.frontend.remote.stocks.StocksService;

@RestController
@RequestMapping("/stocks")
public class StocksController {

	
	@Autowired
	private StocksService stocksService;
	
	@Autowired
	private StocksConverter converter;
	
	
	
	@RequestMapping(method = GET)	
	public List<Stock> getTickerList() {		
		return converter.convert(stocksService.getTickerList());
		
	}



}
