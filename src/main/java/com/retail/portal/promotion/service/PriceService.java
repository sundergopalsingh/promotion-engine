package com.retail.portal.promotion.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PriceService {

	public Map<Character, Integer> getUnitPriceList() {
		// Defining Price for items
		Map<Character, Integer> unitPrice = new HashMap<>();
		unitPrice.put('A', 50);
		unitPrice.put('B', 30);
		unitPrice.put('C', 20);
		unitPrice.put('D', 15);
		return unitPrice;
	}
}
