package com.retail.portal.promotion.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.retail.portal.promotion.config.PromotionConfigurations;
import com.retail.portal.promotion.domain.Promotion;
import com.retail.portal.promotion.entity.Cart;
import com.retail.portal.promotion.entity.Sku;

public class PromotionEngineServiceTest {

	PriceService priceService ;
	List<Promotion> promotion;

	PromotionEngineService promotionEngineService;
	@Before
	public void before() {
		PromotionConfigurations pmConfig = new PromotionConfigurations();
		
		promotion = new ArrayList<>();
		priceService =new PriceService();
		promotion.add(pmConfig.getMultipleItemsPromotion());
		promotion.add(pmConfig.getDifferentItemsPromotion());		
		promotionEngineService = new PromotionEngineService(priceService, promotion);
	}

	@Test
	public void testCartSumForSingleItem() {
		Cart cart = new Cart();
		cart.addItem(new Sku('A'));
		int result = promotionEngineService.calculateOrderPrice(cart);
		Assert.assertEquals((int) priceService.getUnitPriceList().get(new Sku('A')), result);
	}

	@Test
	public void testCartSumForThreeDifferentItems() {
		Cart cart = new Cart();
		cart.addItem(new Sku('A'));
		cart.addItem(new Sku('B'));
		cart.addItem(new Sku('C'));
		Map<Sku, Integer> map = priceService.getUnitPriceList();
			int actualPrice = map.get(new Sku('A')) + map.get(new Sku('B')) + map.get(new Sku('C'));

		int result = promotionEngineService.calculateOrderPrice(cart);

		Assert.assertEquals(actualPrice, result);
	}

	@Test
	public void testCartSumForMultipleOfferItems() {
		Cart cart = new Cart();
		cart.addItem(new Sku('A'));
		cart.addItem(new Sku('A'));
		cart.addItem(new Sku('A'));
		cart.addItem(new Sku('A'));
		cart.addItem(new Sku('A'));
		cart.addItem(new Sku('B'));
		cart.addItem(new Sku('B'));
		cart.addItem(new Sku('B'));
		cart.addItem(new Sku('B'));
		cart.addItem(new Sku('B'));
		cart.addItem(new Sku('C'));
		int actualPrice = 370;

		int result = promotionEngineService.calculateOrderPrice(cart);

		Assert.assertEquals(actualPrice, result);
	}
	@Test
	public void testCartSumForBothOfferItems() {
		Cart cart = new Cart();
		cart.addItem(new Sku('A'));
		cart.addItem(new Sku('A'));
		cart.addItem(new Sku('A'));
		cart.addItem(new Sku('B'));
		cart.addItem(new Sku('B'));
		cart.addItem(new Sku('B'));
		cart.addItem(new Sku('B'));
		cart.addItem(new Sku('B'));
		cart.addItem(new Sku('C'));
		cart.addItem(new Sku('D'));
		int actualPrice = 280;
		
		int result = promotionEngineService.calculateOrderPrice(cart);
		
		Assert.assertEquals(actualPrice, result);
	}
}
