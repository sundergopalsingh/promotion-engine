package com.retail.portal;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.retail.portal.promotion.service.CartService;
import com.retail.portal.promotion.service.PriceService;

@ComponentScan
@SpringBootApplication
public class RetailApplication {

	@Autowired
	private CartService cartService;
	@Autowired
	private PriceService priceService;
	Logger logger = LoggerFactory.getLogger(RetailApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RetailApplication.class, args);

	}

	@PostConstruct
	private void logPriceUsedAndCartValue() {
		logger.info("Cart Used {}", cartService.getSampleCart());
		logger.info("Price Per Item {}", priceService.getUnitPriceList());
	}

}
