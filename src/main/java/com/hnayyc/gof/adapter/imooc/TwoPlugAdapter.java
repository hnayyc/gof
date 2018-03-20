package com.hnayyc.gof.adapter.imooc;
/**
 * 采用组合方式的插座适配器
 * 二相转三相的插座适配器
 */
public class TwoPlugAdapter implements ThreePlugIf {

	private GBTwoPlug plug;
	
	public TwoPlugAdapter(GBTwoPlug plug){
		this.plug = plug;
	}

	@Override
	public void powerWithThree() {
		System.out.println("通过组合方式，实现适配器。");
		plug.powerWithTwo();
	}
}
