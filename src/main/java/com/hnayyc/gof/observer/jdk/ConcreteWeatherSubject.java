package com.hnayyc.gof.observer.jdk;

import java.util.Observable;

/**
 * 天气目标（消息发布者）的具体实现类
 */
public class ConcreteWeatherSubject extends Observable {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        // 天气情况有了，就要通知所有的观察者（消息订阅者）
        this.setChanged(); // 注意：在通知之前，使用Java中的Observer模式的时候，要求必须先执行setChanged()函数。
        // 然后主动通知
        this.notifyObservers(content);  // 推方式
//        this.notifyObservers(); // 拉方式


    }



}
