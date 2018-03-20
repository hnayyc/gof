package com.hnayyc.gof.proxy.imooc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理
 * 通过实现JDK的InvocationHandler接口实现动态代理
 * 说明：只能代理实现了接口的类（代理接口中定义的方法），比如此例中代理的Car类实现了Moveable接口。
 *       没有实现接口的类不能实现JDK的动态代理。
 */
public class JdkProxy implements InvocationHandler {

    private Object target;

    public JdkProxy(Object target) {
        super();
        this.target = target;
    }

    /**
     *
     * @param proxy   被代理对象
     * @param method  被代理对象的方法
     * @param args    被代理对象的方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶......");

        method.invoke(target);

        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶...... 汽车行驶时间：" + (endtime - starttime) + "毫秒！");
        return null;
    }
}
