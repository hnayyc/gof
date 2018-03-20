package com.hnayyc.gof.observer.weather;

/**
 * 观察者接口，定义一个更新的接口给那些在目标发生改变的时候被通知的对象。
 */
public interface WeatherObserver {
    /**
     * 更新的接口
     * @param weatherSubject 传入目标对象，方便获取相应的目标对象的状态。
     */
    public void update(WeatherSubject weatherSubject);
}
