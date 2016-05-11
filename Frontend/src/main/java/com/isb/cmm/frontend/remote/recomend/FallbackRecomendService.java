package com.isb.cmm.frontend.remote.recomend;

import org.springframework.stereotype.Component;

@Component
public class FallbackRecomendService implements RecomendService {

	@Override
	public String getRecommendation(String value) {
		return "0";
	}

}
