package com.isb.cmm.recommendstock.remote.stock;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "stock", fallback=FallbackStockService.class)

public interface StockService {
	
	@RequestMapping(method = RequestMethod.GET, path = "/stockrate/{id}/{dateBegin}/{dateEnd}")
	List<Double> getStockRateHistory(@PathVariable("id") String id, 
			@PathVariable("dateBegin") Date dateBegin, 
			@PathVariable("dateEnd") Date dateEnd);

}
