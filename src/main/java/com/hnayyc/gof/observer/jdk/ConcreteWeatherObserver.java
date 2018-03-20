package com.hnayyc.gof.observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class ConcreteWeatherObserver implements Observer {

    // 观察者（消息订阅者）名称
    private String observerName;

    /**
     * @param subject 目标对象（消息发布者），对应拉的方式
     * @param arg  推送的内容，对应推的方式
     */
    @Override
    public void update(Observable subject, Object arg) {
        // 推方式
        System.out.println(observerName + "收到了消息，目标（消息发布者）推送过来的参数是：" + arg);

        // 拉方式
        System.out.println(observerName + "收到了消息，主动到目标对象（消息发布者）中去拉，拉的内容是："
                + ((ConcreteWeatherSubject)subject).getContent());
    }

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }
}
