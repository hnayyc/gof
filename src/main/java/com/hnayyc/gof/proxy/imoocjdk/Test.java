package com.hnayyc.gof.proxy.imoocjdk;

public class Test {
    public static void main(String[] args) throws Throwable {
        jdkProxy1();
        jdkProxy2();
    }

    public static void jdkProxy1() {
        /**
         * 动态代理实现思路
         * 实现功能：通过Proxy的newProxyInstance返回代理对象
         * 1、声明一段源码（动态产生代理）
         * 2、编译源码（JDK Compiler API），产生新的类（代理类）
         * 3、将产生的代理类load到内存当中，产生一个新的对象（代理对象）
         * 4、return代理对象
         */

        // JDK动态代理灵活方式
        try {
            Car car = new Car();
            InvocationHandler h = new TimeHandler(car);
            Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, h);
            m.move();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void jdkProxy2(){
        // 按照java.lang.reflect.Proxy的newProxyInstance()函数实现JDK动态代理机制
        try {
            Car car = new Car();
            Class<?> carCls = car.getClass();
            InvocationHandler h = new TimeHandler(car);
            Moveable m = (Moveable) Proxy.newProxyInstance(carCls.getClassLoader(), Moveable.class, h);
            m.move();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
