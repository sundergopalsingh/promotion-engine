package com.retail.portal;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.retail.portal.promotion.entity.Cart;
import com.retail.portal.promotion.service.CartService;
import com.retail.portal.promotion.service.PriceService;
import com.retail.portal.promotion.service.PromotionEngineService;

@ComponentScan
@SpringBootApplication
public class RetailApplication {

	@Autowired
	private CartService cartService;
	@Autowired
	private PriceService priceService;
	@Autowired
	private PromotionEngineService promotionEngineService;
	
	Logger logger = LoggerFactory.getLogger(RetailApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RetailApplication.class, args);
		
	}

	@PostConstruct
	private void intitiatePromotionCalculation() {
		logger.info("Price Per Item {}", priceService.getUnitPriceList());
		
		//Use Case 1
		calculateBasedOnCart("ABC");
		
		//Use Case 2
		calculateBasedOnCart("AAABBBCBBAA");
		
		//Use Case 3
		calculateBasedOnCart("AAADBBBBBC");
		
	}
	
	private void calculateBasedOnCart(String cartString) {
		Cart cart = cartService.getSampleCart(cartString);
		logger.info("Cart Used {}", cart);
		
		int result = promotionEngineService.calculateOrderPrice(cart);
		logger.info("Result = "+result);
	}

}
