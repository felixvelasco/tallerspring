package com.isb.cmm.frontend.controller;

import static java.util.Arrays.asList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/opportunities")
public class OpportunityController {

	@RequestMapping(method = GET)
	public Opportunity getOpportunity() {
		Opportunity result = new Opportunity();
		result.setHeader("Crédito bolsa");
		result.setParagraphs(asList(
				"El nuevo crédito bolsa preconcedido le permitirá incrementar sus inversiones con un dinero que no es suyo, aumentando su riesgo y nuestro beneficio.",
				"Le corresponde un crédito preconcedido de:"));
		result.setBait("25.000 €");
		result.setFooter("TAE 7,25%. Crédito a devolver en 48 meses. Contratamos albano-kosovares para cobrar.");
				
		return result;
	}


}
