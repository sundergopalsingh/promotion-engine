package com.retail.portal.promotion.entity;

import java.util.Collections;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class OfferPriceDifferentSkus {

	private List<Sku> skus;
	private Integer price;

	public OfferPriceDifferentSkus(List<Sku> skus, Integer price) {
		if (skus == null || price < 0) {
			throw new IllegalArgumentException("Mandatory params missing or incorrect");
		}
		Collections.sort(skus);
		this.skus = skus;
		this.price = price;

	}
}
