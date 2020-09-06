package com.retail.portal.promotion.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.portal.promotion.domain.Promotion;
import com.retail.portal.promotion.entity.Cart;
import com.retail.portal.promotion.entity.PriceCart;
import com.retail.portal.promotion.entity.Sku;

@Service
public class PromotionEngineService {

	private PriceService priceService;

	List<Promotion> promotion;

	public PromotionEngineService() {

	}

	@Autowired
	public PromotionEngineService(PriceService priceService, List<Promotion> promotion) {
		this.priceService = priceService;
		this.promotion = promotion;
	}

	public Integer calculateOrderPrice(Cart cart) {
		Map<Sku, Integer> priceMap = priceService.getUnitPriceList();
		PriceCart priceCart = new PriceCart(cart, 0);

		for (Promotion p : promotion) {
			if (p.isPromotionApplicable(priceCart.getCartMap().keySet().stream().collect(Collectors.toList()))) {
				p.applyPromotionCalculate(priceCart);
			}
		}
		Integer sum = priceCart.getPreviousItemsSum() + priceCart.getCartMap().keySet().stream()
				.mapToInt((k) -> priceMap.get(k) * priceCart.getCartMap().get(k).intValue()).sum();

		return sum;
	}
}
