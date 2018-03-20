package com.hnayyc.gof.proxy.imooc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
//        testJdkProxy();
        testCglibProxy();
//        testStaticProxy();
    }

    public static void testCglibProxy() {
        CglibProxy proxy = new CglibProxy();
        Train t = (Train)proxy.getProxy(Train.class);
        t.move();
    }

    public static void testJdkProxy() {
        Car car = new Car();
        InvocationHandler h = new JdkProxy(car);
        Class<?> cls = car.getClass();
        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
        m.move();
    }

    public static void testProxyByInherit() {
        // 测试通过继承方式实现静态代理
        System.out.println("----------> 测试通过集成方式实现静态代理 <----------");
        Moveable m = new CarExtends();
        m.move();
    }

    public static void testProxyByImplement() {
        // 测试通过聚合方式实现静态代理
        System.out.println("----------> 测试通过聚合方式实现静态代理 <----------");
        Car car = new Car();
        Moveable m = new CarByImplement(car);
        m.move();
    }

    public static void testStaticProxy() {

        // 测试通过聚合方式实现静态代理模式，并且实现代理功能叠加。
        System.out.println("----------> 测试通过聚合方式实现静态代理模式，并且实现代理功能叠加。 <----------");
        Car car = new Car();
        // 代理顺序一
        System.out.println("代理顺序一：先记录日志，再记录时间");
        CarTimeProxy carTimeProxy1 = new CarTimeProxy(car);
        CarLogProxy carLogProxy1 = new CarLogProxy(carTimeProxy1);
        carLogProxy1.move();
        // 代理顺序二
        System.out.println("代理顺序一：先记录时间，再记录日志");
        CarLogProxy carLogProxy2 = new CarLogProxy(car);
        CarTimeProxy carTimeProxy2 = new CarTimeProxy(carLogProxy2);
        carTimeProxy2.move();
    }
}
