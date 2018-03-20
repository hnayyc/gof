package com.hnayyc.gof.observer.egweather;

/**
 * 定义一个更新的接口方法给那些在目标（消息发布者要发布的内容）发生改变
 * 的时候，被通知的观察者（消息订阅者）对象调用。
 */
public interface Observer {
    /**
     * 更新的接口
     * @param subject
     */
    public void update(WeatherSubject subject);

    /**
     * 设置观察者（消息订阅者）名称
     * @param observerName
     */
    public void setObserverName(String observerName);

    /**
     * 取得观察者（消息订阅者）名称
     * @return
     */
    public String getObserverName();
}
