package com.hnayyc.gof.strategy.impl;

import com.hnayyc.gof.strategy.FlyingStragety;

public class FlyWithRocket implements FlyingStragety {

	public void performFly() {
		System.out.println("用火箭在太空遨游");
	}

}
