package com.hnayyc.gof.proxy.me;

public class ProxyTime implements TargetInterface {
    private TargetInterface target;

    public ProxyTime(TargetInterface target) {
        super();
        this.target = target;
    }

    public void before() {
        System.out.println("时间开始记录......");
    }

    public void after() {
        System.out.println("时间结束记录......");
    }

    @Override
    public void move() {
        this.before();
        this.target.move();
        this.after();
    }
}
