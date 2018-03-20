package com.hnayyc.gof.strategy.impl;

import com.hnayyc.gof.strategy.FlyingStragety;

public class FlyNoWay implements FlyingStragety {

	public void performFly() {
		System.out.println("我不会飞行！");
	}

}
