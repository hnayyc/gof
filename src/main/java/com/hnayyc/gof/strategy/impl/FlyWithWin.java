package com.hnayyc.gof.strategy.impl;

import com.hnayyc.gof.strategy.FlyingStragety;

public class FlyWithWin implements FlyingStragety {

	public void performFly() {
		System.out.println("振翅高飞");
	}

}
