package com.hnayyc.gof.proxy.imooc;

/**
 * 静态代理
 * 通过聚合的方式实现静态代理（推荐）
 * 聚合：在一个类中调用另一个类的对象
 */
public class CarLogProxy implements Moveable {

    private Moveable moveable;

    public CarLogProxy(Moveable moveable) {
        super();
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("日志开始......");
        moveable.move();
        System.out.println("日志结束......");
    }

}
