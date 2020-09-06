package com.retail.portal.promotion.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.retail.portal.promotion.entity.OfferPriceDifferentSkus;
import com.retail.portal.promotion.entity.OfferPriceSkuTimes;
import com.retail.portal.promotion.entity.Sku;
import com.retail.portal.promotion.types.DifferentItemsPromotion;
import com.retail.portal.promotion.types.MultipleItemsPromotion;

@Configuration
public class PromotionConfigurations {

	@Bean
	public MultipleItemsPromotion getMultipleItemsPromotion() {
		List<OfferPriceSkuTimes> list = new ArrayList<>();

		list.add(new OfferPriceSkuTimes(new Sku('A'), 3, 130));
		list.add(new OfferPriceSkuTimes(new Sku('B'), 2, 45));
		return new MultipleItemsPromotion(list);
	}

	@Bean
	public DifferentItemsPromotion getDifferentItemsPromotion() {
		List<OfferPriceDifferentSkus> offerPriceDifferentSkus = new ArrayList<>();
		List<Sku> skuList = new ArrayList<>();
		skuList.add(new Sku('C'));
		skuList.add(new Sku('D'));

		offerPriceDifferentSkus.add(new OfferPriceDifferentSkus(skuList, 30));
		return new DifferentItemsPromotion(offerPriceDifferentSkus);
	}
}
