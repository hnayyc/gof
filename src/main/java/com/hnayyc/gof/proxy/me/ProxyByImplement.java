package com.hnayyc.gof.proxy.me;

/**
 * 其实这个类不实现TargetInterface接口也行。
 */
public class ProxyByImplement implements TargetInterface {
    private TargetInterface target;

    public ProxyByImplement(TargetInterface target) {
        super();
        this.target = target;
    }

    public void before() {
        System.out.println("通过实现接口被代理目标类，代理之前实现增强功能......");
    }

    public void after() {
        System.out.println("通过实现接口被代理目标类，代理之后实现增强功能......");
    }

    @Override
    public void move() {
        this.before();
        target.move();
        this.after();
    }
}
