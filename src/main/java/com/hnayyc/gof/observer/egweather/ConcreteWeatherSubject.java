package com.hnayyc.gof.observer.egweather;

public class ConcreteWeatherSubject extends WeatherSubject{

    /**
     * 目标对象的状态
     * 天气信息存储变量，存储：“晴天”，“下雨”，“下雪”
     */
    private String weatherContent;

    @Override
    protected void notifyObservers() {
        // 循环所有注册的观察者（消息订阅者）
        for(Observer observer : observers) {
            // 发布消息规则是：黄明女友只关心“下雨”；黄明老妈关心“下雨”和“下雪”。

            // 如果天气是晴天
            // do nothing

            // 如果天气是下雨
            if("下雨".equals(this.getWeatherContent())) {
                if("黄明的女朋友".equals(observer.getObserverName())) {
                    observer.update(this);
                }
                if("黄明的老妈".equals(observer.getObserverName())) {
                    observer.update(this);
                }
            }

            // 如果天气是下雪
            if("下雪".equals(this.getWeatherContent())) {
                if("黄明的老妈".equals(observer.getObserverName())) {
                    observer.update(this);
                }
            }
        }
    }

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
        this.notifyObservers();
    }
}
