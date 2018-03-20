package com.hnayyc.gof.observer.egweather;

public class ConcreteWeatherObserver implements Observer {

    // 观察者（消息订阅者）名称
    private String observerName;

    // 天气情况的内容
    private String weatherContent;

    // 提醒的内容
    private String remindThing;

    @Override
    public void update(WeatherSubject subject) {
        String weatherContent = ((ConcreteWeatherSubject)subject).getWeatherContent();
        setWeatherContent(weatherContent);
        System.out.println(observerName + "收到了" + getWeatherContent() + "，" + getRemindThing());
    }

    @Override
    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public String getObserverName() {
        return observerName;
    }

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
    }

    public String getRemindThing() {
        return remindThing;
    }

    public void setRemindThing(String remindThing) {
        this.remindThing = remindThing;
    }
}
