package com.retail.portal.promotion.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class OfferPriceSkuTimes {
	private Sku sku;
	private Integer times;
	private Integer price;

	public OfferPriceSkuTimes(Sku sku, Integer times, Integer price) {
		if (times <= 0 || price < 0 || sku == null) {
			throw new IllegalArgumentException("Not fullfilling the required criteria");
		}
		this.sku = sku;
		this.times = times;
		this.price = price;
		
	}
}
