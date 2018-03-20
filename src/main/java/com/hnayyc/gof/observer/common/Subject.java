package com.hnayyc.gof.observer.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象，他知道观察它的观察者，并提供注册（添加）和删除观察者的接口。
 */
public class Subject {

    // 用来保存注册的观察者对象
    private List<Observer> observers = new ArrayList<Observer>();

    // 添加新的观察者到observers集合中
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // 删除observers集合中的指定观察者
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    // 通知observers集合中的所有已注册的观察者
    // 使用protected修饰，只允许子类调用。
    protected void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(this);
        }
    }
}
