package com.isb.cmm.frontend.remote.opportunities;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "promos", fallback=FallbackOpportunityService.class)
public interface OpportunityService {
	
	@RequestMapping(method = RequestMethod.GET, path = "/opportunity/{id}")
	TheOpportunity getOpportunity(@PathVariable("id") Long userId);
	
}
