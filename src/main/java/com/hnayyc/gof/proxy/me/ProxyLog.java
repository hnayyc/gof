package com.hnayyc.gof.proxy.me;

public class ProxyLog implements TargetInterface {
    private TargetInterface target;

    public ProxyLog(TargetInterface target) {
        super();
        this.target = target;
    }

    public void before() {
        System.out.println("日志开始记录......");
    }

    public void after() {
        System.out.println("日志结束记录......");
    }

    @Override
    public void move() {
        this.before();
        this.target.move();
        this.after();
    }
}
