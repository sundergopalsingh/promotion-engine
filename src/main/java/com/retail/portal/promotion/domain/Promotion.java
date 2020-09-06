package com.retail.portal.promotion.domain;

import java.util.List;

import com.retail.portal.promotion.entity.PriceCart;
import com.retail.portal.promotion.entity.Sku;

public interface Promotion {
	
	boolean isPromotionApplicable(List<Sku> items);
	
	void applyPromotionCalculate(PriceCart cart);
}
