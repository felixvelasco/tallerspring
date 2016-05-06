package com.taller.valores.remote.stock;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "stock", fallback = FallbackStocksService.class)
public interface StocksService {

	@RequestMapping(method = RequestMethod.GET, path = "/stockrate/{id}")
	public double getStockRate(@PathVariable("id") String stockId);
}
