package com.hnayyc.gof.proxy.me;

public class TargetClass implements TargetInterface {

    @Override
    public void move(){
        System.out.println(">>>>>>>>>> 被代理目标类运行中 <<<<<<<<<<");
    }
}
