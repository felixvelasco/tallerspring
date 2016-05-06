package com.isb.cmm.recommendstock.remote.stock;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FallbackStockService implements StockService {

	@Override
	public List<Double> getStockRateHistory(String id, Date dateBegin, Date dateEnd) {
		return Collections.emptyList();
	}

}
