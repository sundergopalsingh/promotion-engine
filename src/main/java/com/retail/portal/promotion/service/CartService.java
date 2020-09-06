package com.retail.portal.promotion.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.retail.portal.promotion.entity.Cart;

@Service
public class CartService {

	public Cart getSampleCart() {
		String itemsAsString = "AAADBBBBBC";
		return new Cart(itemsAsString.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
	}

}
