package com.isb.cmm.frontend.remote.opportunities;

import static java.util.Arrays.asList;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FallbackOpportunityService implements OpportunityService {

	private static final String[] BAITS = new String[] { "25.000","50.000","100.000","0.99"};

	@Override
	public TheOpportunity getOpportunity(Long userId) {
		TheOpportunity oppor = new TheOpportunity();
		oppor.setHeader("Crédito bolsa para "+userId);
		oppor.setParagraphs(asList(
				"El nuevo crédito bolsa preconcedido le permitirá incrementar sus inversiones con un dinero que no es suyo, aumentando su riesgo y nuestro beneficio.",
				"Le corresponde un crédito preconcedido de:"));
		oppor.setBait(BAITS[new Random().nextInt(BAITS.length)]+" €");
		oppor.setFooter("TAE 7,25%. Crédito a devolver en 48 meses. Contratamos albano-kosovares para cobrar.");
		return oppor;
	}

}
