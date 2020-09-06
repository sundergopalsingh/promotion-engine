package com.retail.portal.promotion.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity Class for Cart. <br>
 * Responsible for maintaining the cart for a user
 * 
 * @author Sunder Gopal Singh
 *
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cart {

	private List<Sku> skuIds;

	public Cart() {
		skuIds = new ArrayList<Sku>();
	}

	public Cart addItem(Sku item) {
		this.skuIds.add(item);
		return this;
	}

}
