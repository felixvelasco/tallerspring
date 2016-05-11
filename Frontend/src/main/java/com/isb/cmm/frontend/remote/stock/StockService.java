package com.isb.cmm.frontend.remote.stock;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "stock", fallback=FallbackStockService.class)
public interface StockService {


 	@RequestMapping(method = RequestMethod.GET, path = "/stock/{id}/value")
	double getValue(@PathVariable("id") String id);
	
}
