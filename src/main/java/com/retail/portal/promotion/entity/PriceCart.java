package com.retail.portal.promotion.entity;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode
public class PriceCart {

	@Getter
	private Map<Sku, Long> cartMap;

	@Getter
	@Setter
	private Integer previousItemsSum;

	public PriceCart(Cart cart, Integer previousItemsSum) {
		setCartMap(cart);
		this.previousItemsSum = previousItemsSum;
	}

	public void setCartMap(Cart cart) {
		if (cart == null) {
			throw new IllegalArgumentException("cart can not be empty");
		}
		Map<Sku, Long> cartMap = cart.getSkuIds().stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		this.cartMap = cartMap;
	}
}
