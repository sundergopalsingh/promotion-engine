package com.retail.portal.promotion.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.retail.portal.promotion.entity.Cart;
import com.retail.portal.promotion.entity.Sku;

@Service
public class CartService {

	public Cart getSampleCart(String itemsAsString) {
		return new Cart(itemsAsString.chars().mapToObj(c -> new Sku((char)c)).collect(Collectors.toList()));
	}

}
