package com.hnayyc.gof.proxy.me;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;

public class Test {

    public static void main(String[] args) {
//        staticProxyByExtends();
//        staticProxyByImplement();
//        staticProxyByAggregation();
        dynamicProxyByJdk();
//        dynamicProxyByCglib();
    }

    public static void dynamicProxyByJdk() {
        TargetClass target = new TargetClass();
        Class<?> targetCls = target.getClass();
        InvocationHandler h = new ProxyByJdk(target);

        /**
         * Proxy.newProxyInstance()参数说明
         * ClassLoader loader
         * Class<?>[] interfaces
         * InvocationHandler h
         */
        TargetInterface targetInterface = (TargetInterface) Proxy.newProxyInstance(targetCls.getClassLoader(), targetCls.getInterfaces(), h);
        targetInterface.move();
    }

    public static void dynamicProxyByCglib() {
        ProxyByCglib proxy = new ProxyByCglib();
        TargetClass target = (TargetClass)proxy.getProxy(TargetClass.class);
        target.move();
    }

    public static void staticProxyByExtends() {
        // 通过接口向上转型调用move()方法
        TargetInterface obj = new ProxyByExtends();
        obj.move();

        // 通过子类向上转型调用move()方法
        TargetClass subCls = new ProxyByExtends();
        subCls.move();
    }

    public static void staticProxyByImplement() {
        TargetClass target = new TargetClass();
        TargetInterface obj = new ProxyByImplement(target);
        obj.move();
    }

    public static void staticProxyByAggregation() {
        TargetClass target = new TargetClass();

        ProxyLog proxyLog = new ProxyLog(target);
        ProxyTime proxyTime = new ProxyTime(proxyLog);
        proxyTime.move();

        ProxyTime proxyTime1 = new ProxyTime(target);
        ProxyLog proxyLog1 = new ProxyLog(proxyTime1);
        proxyLog1.move();
    }
}
