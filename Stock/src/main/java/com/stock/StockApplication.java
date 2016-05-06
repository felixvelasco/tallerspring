package com.stock;

import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StockApplication {

	public static void main(String[] args) {
        String encoded = new String(Base64.getEncoder().encode(("user" + ":" + "password").getBytes()));
        //con.setRequestProperty("Proxy-Authorization", "Basic " + encoded);
        //Authenticator.setDefault(new Authenticator(getHTTPUsername(), getHTTPPassword()));

		
		SpringApplication.run(StockApplication.class, args);
	}
}
