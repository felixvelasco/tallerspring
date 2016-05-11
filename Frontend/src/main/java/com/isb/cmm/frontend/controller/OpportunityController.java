package com.isb.cmm.frontend.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isb.cmm.frontend.remote.opportunities.OpportunityService;

@RestController
@RequestMapping("/opportunities")
public class OpportunityController {

	
	
	@Autowired
	private OpportunityService opportunityService;
	
	@Autowired
	private OpportunityConverter converter;
	
	@RequestMapping(method = GET)
	public Opportunity getOpportunity(@PathVariable("id") Long userId) {		
		return converter.convert(opportunityService.getOpportunity(userId));
	}	

}
