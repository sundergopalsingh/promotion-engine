package com.retail.portal.promotion.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.retail.portal.promotion.entity.Sku;

@Service
public class PriceService {

	public Map<Sku, Integer> getUnitPriceList() {
		// Defining Price for items
		Map<Sku, Integer> unitPrice = new HashMap<>();
		unitPrice.put(new Sku('A'), 50);
		unitPrice.put(new Sku('B'), 30);
		unitPrice.put(new Sku('C'), 20);
		unitPrice.put(new Sku('D'), 15);
		return unitPrice;
	}
}
