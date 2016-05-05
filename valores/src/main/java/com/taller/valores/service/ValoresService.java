package com.taller.valores.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.valores.remote.stock.StocksService;
import com.taller.valores.repository.Stock;
import com.taller.valores.repository.StockRepository;

@Service
public class ValoresService {

	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private StocksService stocksService;
	
	public List<Valor> getStockList() {
		
		List<Stock> stocks = stockRepository.findAll();
		return mapStock2Valor(stocks);
	}
	
	public double getStockValue(String stockId){
		Stock stock = stockRepository.findByName(stockId);
		double stockRate = stocksService.getStockRate(stock.getName());
		
		return stock.getQuantity() * stockRate;
	}
	
	private List<Valor> mapStock2Valor(List<Stock> stocks){
		
		List<Valor> result = new ArrayList<Valor>();
		for(Stock stock : stocks){
			Valor valor = createValorFromStock(stock);
			result.add(valor);
		}
		return result;
	}

	private Valor createValorFromStock(Stock stock) {
		Valor valor = new Valor();
		valor.setId(stock.getId());
		valor.setName(stock.getName());
		valor.setQuantity(stock.getQuantity());
		double stockRate = stocksService.getStockRate(stock.getName());
		valor.setValue(stock.getQuantity() * stockRate);
		return valor;
	}
}
