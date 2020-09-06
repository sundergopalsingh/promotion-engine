package com.retail.portal.promotion.types;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.retail.portal.promotion.domain.Promotion;
import com.retail.portal.promotion.entity.OfferPriceDifferentSkus;
import com.retail.portal.promotion.entity.PriceCart;
import com.retail.portal.promotion.entity.Sku;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DifferentItemsPromotion implements Promotion {

	private List<OfferPriceDifferentSkus> offerPriceSkuTimes;

	@Override
	public boolean isPromotionApplicable(List<Sku> items) {
		Collections.sort(items);

		for (OfferPriceDifferentSkus o : offerPriceSkuTimes) {
			boolean isPresent = true;
			for (Sku s : o.getSkus()) {
				if (!items.contains(s)) {
					isPresent = false;
					break;
				}
			}
			if (isPresent) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void applyPromotionCalculate(PriceCart cart) {
		for (OfferPriceDifferentSkus o : offerPriceSkuTimes) {
			boolean isPresent = true;
			for (Sku s : o.getSkus()) {
				if (cart.getCartMap().get(s) == null) {
					isPresent = false;
					break;
				}
			}
			if (isPresent) {
				for (Sku s : o.getSkus()) {
					long reducedValue = cart.getCartMap().get(s) - 1;
					if (reducedValue > -1) {
						cart.getCartMap().put(s, reducedValue);
					}
				}
				cart.setPreviousItemsSum(cart.getPreviousItemsSum()+
						o.getPrice());
			}
		}

	}

}
