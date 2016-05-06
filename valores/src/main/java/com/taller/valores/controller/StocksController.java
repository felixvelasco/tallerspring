package com.taller.valores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taller.valores.service.Valor;
import com.taller.valores.service.ValoresService;

@RestController
@RequestMapping("/stocks")
public class StocksController {
	
	@Autowired
	private ValoresService service;
		
	
	@RequestMapping(path = "/{stock}", method = RequestMethod.GET)
	public double getStockValue(@PathVariable("stock") String stockId) {
		
		return service.getStockValue(stockId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Valor> getStockList() {
		
		return service.getStockList();
	}

}
