package com.hnayyc.gof.chainofresponsibility.handler;

/*
 * 价格处理人，负责处理客户折扣申请
 */
public abstract class PriceHandler {
	
	/*
	 * 直接后继，用于传递请求（数据结构中，链表的实现会用到后继这个技术。）
	 */
	protected PriceHandler successor;

	public void setSuccessor(PriceHandler successor) {
		this.successor = successor;
	}
	
	/*
	 * 处理折扣申请
	 */
	public abstract  void processDiscount(float discount);

}
