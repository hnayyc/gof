package com.hnayyc.gof.observer.egweather;

public class Test {
    public static void main(String[] args) {
        // 1、创建目标（消息发布者）
        ConcreteWeatherSubject weatherSubject = new ConcreteWeatherSubject();

        // 2、创建观察者（消息订阅者）
        ConcreteWeatherObserver observerGirl = new ConcreteWeatherObserver();
        observerGirl.setObserverName("黄明的女朋友");
        observerGirl.setRemindThing("下雨了，安静的呆在家里吧。");
        ConcreteWeatherObserver observerMum = new ConcreteWeatherObserver();
        observerMum.setObserverName("黄明的老妈");
        observerMum.setRemindThing("不管下雨或者下雪，都不要出门。");

        // 3、注册观察者（消息订阅者）
        weatherSubject.attach(observerGirl);
        weatherSubject.attach(observerMum);

        // 4、目标（消息发布者）发布天气
        weatherSubject.setWeatherContent("下雪");
    }
}
