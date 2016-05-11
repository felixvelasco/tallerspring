package com.isb.cmm.frontend.remote.recomend;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "recommendStock", fallback=FallbackRecomendService.class)
public interface RecomendService {

 	@RequestMapping(method = RequestMethod.GET, path = "/recommendStock/{value}")
	String getRecommendation(@PathVariable("value") String value);
	
}
