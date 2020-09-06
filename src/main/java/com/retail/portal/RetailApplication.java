package com.retail.portal;

import com.retail.portal.promotion.entity.Cart;

public class RetailApplication {

	public static void main(String[] args) {
		System.out.println("Starting Application");
		
		//Creating a cart for calculating the price
		Cart cart = new Cart();
		cart.addItem('A').addItem('B').addItem('C').addItem('D')
		.addItem('A').addItem('D').addItem('E').addItem('A');
		
		System.out.println("Cart used"+ cart);
	}

}
