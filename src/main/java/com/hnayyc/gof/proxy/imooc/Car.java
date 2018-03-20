package com.hnayyc.gof.proxy.imooc;

import java.util.Random;

/**
 * 无代理
 */
public class Car implements Moveable {

    @Override
    public void move() {
        //实现开车
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
