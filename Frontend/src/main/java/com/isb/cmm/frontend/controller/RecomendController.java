package com.isb.cmm.frontend.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isb.cmm.frontend.remote.recomend.RecomendService;

@RestController
@RequestMapping("/recommendStock")
public class RecomendController {

	
	
	@Autowired
	private RecomendService recService;
	
	
	@RequestMapping(method = GET)
	public String getOpportunity(@PathVariable("value") String value) {		
		return (recService.getRecommendation(value));
	}	

	
	
}
