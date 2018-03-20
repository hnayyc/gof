package com.hnayyc.gof.proxy.me;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProxyByJdk implements InvocationHandler {

    private Object target;

    public ProxyByJdk(Object target) {
        super();
        this.target = target;
    }

    public void before() {
        System.out.println("JDK动态代理before()......");
    }

    public void after() {
        System.out.println("JDK动态代理after()......");
    }

    /**
     * @param proxy   被代理对象
     * @param method  被代理对象的方法
     * @param args    被代理对象的方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            this.before();
            method.invoke(target);
            this.after();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}

