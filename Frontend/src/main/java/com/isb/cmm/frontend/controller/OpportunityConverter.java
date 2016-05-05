package com.isb.cmm.frontend.controller;

import org.springframework.stereotype.Component;

import com.isb.cmm.frontend.remote.opportunities.TheOpportunity;

@Component
public class OpportunityConverter 
{

	public Opportunity convert(TheOpportunity opportunity) 
	{
		Opportunity oppo = new Opportunity();
		oppo.setBait(opportunity.getBait());
		oppo.setFooter(opportunity.getFooter());
		oppo.setHeader(opportunity.getHeader());
		oppo.setParagraphs(opportunity.getParagraphs());
		return oppo;
	}
	
}
