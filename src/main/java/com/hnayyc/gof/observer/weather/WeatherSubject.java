package com.hnayyc.gof.observer.weather;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象，他知道观察它的观察者，并提供注册（添加）和删除观察者的接口。
 */
public class WeatherSubject {

    // 用来保存注册的观察者对象
    private List<WeatherObserver> observers = new ArrayList<WeatherObserver>();

    /**
     * 把订阅天气的人（观察者）添加到订阅者列表中
     * @param observer
     */
    public void attach(WeatherObserver observer) {
        observers.add(observer);
    }

    /**
     * 删除observers集合中的指定订阅天气的人（观察者）
     * @param observer
     */
    public void detach(WeatherObserver observer) {
        observers.remove(observer);
    }

    /**
     * 通知所有已经订阅天气的人（观察者）
     * 使用protected修饰，只允许子类调用。
     */
    protected void notifyObservers() {
        for(WeatherObserver observer : observers) {
            observer.update(this);
        }
    }
}
