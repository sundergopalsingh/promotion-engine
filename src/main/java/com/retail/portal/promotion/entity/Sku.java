package com.retail.portal.promotion.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Sku implements Comparable<Sku> {
	private Character id;

	@Override
	public int compareTo(Sku sku) {
		return this.id.compareTo(sku.id);
	}
}
