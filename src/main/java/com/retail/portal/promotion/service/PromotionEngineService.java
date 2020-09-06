package com.retail.portal.promotion.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.portal.promotion.entity.Cart;

@Service
public class PromotionEngineService {

	private PriceService priceService;

	public PromotionEngineService() {

	}

	@Autowired
	public PromotionEngineService(PriceService priceService) {
		this.priceService = priceService;
	}

	public Integer calculateOrderPrice(Cart cart) {
		Map<Character,Integer> priceMap = priceService.getUnitPriceList();
		Integer sum =cart.getSkuIds().stream().mapToInt(c->priceMap.get(c)).sum();
		return sum;
	}
}
