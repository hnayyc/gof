package com.hnayyc.gof.proxy.me;

/**
 * 把目标代理类作为父类，通过调用父类方法的手段，实现代理功能。
 */
public class ProxyByExtends extends TargetClass {

    public void before() {
        System.out.println("通过继承被代理目标类，实现代理之前实现增强功能......");
    }

    public void after() {
        System.out.println("通过继承被代理目标类，实现代理之后实现增强功能......");
    }

    @Override
    public void move() {
        this.before();
        super.move();
        this.after();
    }
}
