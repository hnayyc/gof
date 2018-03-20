package com.hnayyc.gof.observer.egweather;

import java.util.ArrayList;
import java.util.List;

public abstract class WeatherSubject {
    /**
     * 订阅列表，用来保存所有注册的观察者（消息订阅者）
     */
    public List<Observer> observers = new ArrayList<Observer>();

    /**
     * 把订阅天气的人（观察者）添加到订阅列表中
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 删除集合中指定的订阅天气的人（观察者）
     * @param observer
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 此处与经典观察者模式代码不同，要注意！！！！！
     * 区别对待观察者（消息订阅者）的要求，就需要在子类实现。
     * 使用protected修饰本方法，是为了限制只能由子类继承该方法。
     */
    protected abstract void notifyObservers();

}
