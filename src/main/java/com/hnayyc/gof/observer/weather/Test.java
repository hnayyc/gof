package com.hnayyc.gof.observer.weather;

public class Test {
    public static void main(String[] args) {
        // Setp1 : 创建目标（消息发布者）
        ConcreteWeatherSubject weather = new ConcreteWeatherSubject();

        // Step2 : 创建观察者（消息订阅者）
        ConcreteWeatherObserver observerGirl = new ConcreteWeatherObserver();
        observerGirl.setObserverName("黄明的女友");
        observerGirl.setRemindThing("是我们的第一次约会，地点街心公园，不见不散。");
        ConcreteWeatherObserver observerMum = new ConcreteWeatherObserver();
        observerMum.setObserverName("黄明的老妈");
        observerMum.setRemindThing("是一个购物的好日子，明天去天虹扫货。");

        // Step3 : 注册观察者（消息订阅者）到目标对象（消息发布者）的观察者列表
        weather.attach(observerGirl);
        weather.attach(observerMum);

        // Step4 : 目标（消息发布者）发布天气
        weather.setWeatherContent("明天天气晴朗，蓝天白云，气温28度。");
    }
}
