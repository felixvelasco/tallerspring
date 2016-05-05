package com.isb.cmm.frontend.remote.stocks;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "stocks", fallback=FallbackStocksService.class)
public interface StocksService {


 	@RequestMapping(method = RequestMethod.GET, path = "/stocks")
 	List<TheStock> getTickerList();
 	
	
}
