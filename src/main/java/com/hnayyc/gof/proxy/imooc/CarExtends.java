package com.hnayyc.gof.proxy.imooc;

/**
 * 静态代理
 * 通过继承模式实现静态代理（不推荐）
 */
public class CarExtends extends Car {

    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶......");

        super.move();

        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶......汽车行驶时间：" + (endtime-starttime) + "毫秒");
    }
}
