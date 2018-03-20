package com.hnayyc.gof.chainofresponsibility;

import com.hnayyc.gof.chainofresponsibility.handler.PriceHandler;

/**
 * 客户，请求折扣
 */
public class Customer {
	
	private PriceHandler priceHandler;
	
	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}

	public void requestDiscount(float discount){
		priceHandler.processDiscount(discount);
	}
}
