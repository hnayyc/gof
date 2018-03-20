package com.hnayyc.gof.strategy;

import com.hnayyc.gof.strategy.impl.FlyWithWin;

public class RedheadDuck extends Duck {

	public RedheadDuck(){
		super();
		super.setFlyingStragety(new FlyWithWin());
	}
	
	@Override
	public void display() {
		System.out.println("我的头是红色的");
	}

}
