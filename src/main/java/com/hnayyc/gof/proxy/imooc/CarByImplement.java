package com.hnayyc.gof.proxy.imooc;

/**
 * 静态代理
 * 通过聚合的方式实现静态代理（推荐）
 * 聚合：在一个类中调用另一个类的对象
 */
public class CarByImplement implements Moveable {

    private Car car;

    public CarByImplement(Car car) {
        super();
        this.car = car;
    }

    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶......");

        car.move();

        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶......汽车行驶时间：" + (endtime-starttime) + "毫秒");
    }

}
