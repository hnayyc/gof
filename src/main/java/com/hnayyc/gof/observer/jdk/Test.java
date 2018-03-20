package com.hnayyc.gof.observer.jdk;

public class Test {
    public static void main(String[] args) {
        // 创建天气作为一个目标，也可以说是消息发布者。
        ConcreteWeatherSubject subject = new ConcreteWeatherSubject();

        // 创建黄明的女朋友作为观察者（消息订阅者）
        ConcreteWeatherObserver girl = new ConcreteWeatherObserver();
        girl.setObserverName("黄明的女朋友");
        // 创建黄明的老妈作为观察者（消息订阅者）
        ConcreteWeatherObserver mum = new ConcreteWeatherObserver();
        mum.setObserverName("黄明的老妈");

        // 注册观察者（消息订阅者）
        subject.addObserver(girl);
        subject.addObserver(mum);

        // 目标（消息发布者）更新天气情况
        subject.setContent("天气晴，气温28度。");
    }
}
