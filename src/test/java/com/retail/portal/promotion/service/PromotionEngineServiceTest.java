package com.retail.portal.promotion.service;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.retail.portal.promotion.entity.Cart;

public class PromotionEngineServiceTest {

	PromotionEngineService promotionEngineService;

	PriceService priceService = new PriceService();

	@Before
	public void before() {
		priceService = new PriceService();

		promotionEngineService = new PromotionEngineService(priceService);
	}

	@Test
	public void testCartSumForSingleItem() {
		Cart cart = new Cart();
		cart.addItem('A');
		int result = promotionEngineService.calculateOrderPrice(cart);
		Assert.assertEquals((int)priceService.getUnitPriceList().get('A'), result);
	}
	
	@Test
	public void testCartSumForThreeDifferentItems() {
		Cart cart = new Cart();
		cart.addItem('A');
		cart.addItem('B');
		cart.addItem('C');
		Map<Character,Integer> map = priceService.getUnitPriceList();
		int actualPrice = map.get('A')+map.get('B')+map.get('C');
		
		int result = promotionEngineService.calculateOrderPrice(cart);
		
		Assert.assertEquals(actualPrice, result);
	}
}
