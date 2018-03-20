package com.hnayyc.gof.proxy.me;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyByCglib  implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class cls) {
        //设置创建子类的类
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public void before() {
        System.out.println("Cglib动态代理before()......");
    }

    public void after() {
        System.out.println("Cglib动态代理after()......");
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) {
        try {
            this.before();
            methodProxy.invokeSuper(obj, args);
            this.after();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
