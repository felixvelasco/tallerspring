package com.isb.cmm.frontend.controller;

import static java.util.Arrays.asList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticker")
public class TickerController {

	@RequestMapping(method = GET)
	public List<String> getTickerList() {
		return asList("GOOGL", "NFLX", "FB");
	}

	@RequestMapping(path="/{ticker}", method = GET)
	public double getTickerValue(@PathVariable("ticker") String ticker) {
		if ("GOOGL".equals(ticker))
			return 750.23;
		if ("NFLX".equals(ticker))
			return 95.20;
		if ("GOOGL".equals(ticker))
			return 109.32;

		return 0.0;
	}

	@RequestMapping(path="/{ticker}/historic", method = GET)
	public List<Double> getTickerHistoric(@PathVariable("ticker") String ticker, @RequestParam(defaultValue="15") int days) {
     	double y = getTickerValue(ticker);

     	List<Double> result = new ArrayList<>();
     	for (int i=0;i<days;i++) {
      		y += (Math.random() * 12 - 5);
      		result.add(y);
     	}

		return result;
	}

}
