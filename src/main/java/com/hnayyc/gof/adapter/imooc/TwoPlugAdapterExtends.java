package com.hnayyc.gof.adapter.imooc;

/**
 * 采用继承方式的插座适配器
 * 二相转三相的插座适配器
 */
public class TwoPlugAdapterExtends extends GBTwoPlug implements ThreePlugIf {

	@Override
	public void powerWithThree() {
		System.out.println("通过继承方式，实现适配器。");
		this.powerWithTwo();
	}

}
