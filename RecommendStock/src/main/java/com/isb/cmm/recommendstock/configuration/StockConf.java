package com.isb.cmm.recommendstock.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("stocks")
public class StockConf {
	public int days;

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}


}
