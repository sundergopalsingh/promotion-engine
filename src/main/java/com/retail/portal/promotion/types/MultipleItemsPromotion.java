package com.retail.portal.promotion.types;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.retail.portal.promotion.domain.Promotion;
import com.retail.portal.promotion.entity.OfferPriceSkuTimes;
import com.retail.portal.promotion.entity.PriceCart;
import com.retail.portal.promotion.entity.Sku;

@Component
public class MultipleItemsPromotion implements Promotion {

	private Map<Sku, OfferPriceSkuTimes> offerPriceSkuTimes;

	public MultipleItemsPromotion(List<OfferPriceSkuTimes> list) {
		if (list == null) {
			throw new IllegalArgumentException("list can not be null");
		}
		offerPriceSkuTimes = list.stream().collect(Collectors.toMap(OfferPriceSkuTimes::getSku, Function.identity()));
	}

	@Override
	public boolean isPromotionApplicable(List<Sku> items) {
		Optional<Sku> optionalSku = items.stream().filter((i) -> offerPriceSkuTimes.containsKey(i)).findAny();

		return optionalSku.isPresent();
	}

	@Override
	public void applyPromotionCalculate(PriceCart priceCart) {

		offerPriceSkuTimes.keySet().stream().filter((k) -> priceCart.getCartMap().containsKey(k)).forEach((k) -> {
			Long count = priceCart.getCartMap().get(k);
			Integer times = offerPriceSkuTimes.get(k).getTimes();
			if (count >= times) {
				int numberOfOccurence = count.intValue() / times;
				priceCart.setPreviousItemsSum(
						priceCart.getPreviousItemsSum() + (numberOfOccurence * offerPriceSkuTimes.get(k).getPrice()));
				priceCart.getCartMap().put(k, count - (numberOfOccurence * times));
			}
		});
	}

}
