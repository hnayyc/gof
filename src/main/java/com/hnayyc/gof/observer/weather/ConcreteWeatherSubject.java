package com.hnayyc.gof.observer.weather;

/**
 * 具体目标对象，负责把有关状态存入到相应的观察者对象中。
 */
public class ConcreteWeatherSubject extends WeatherSubject {
    //目标对象的状态
    private String weatherContent;

    public String getWeatherContent() {
        return weatherContent;
    }

    public void setWeatherContent(String weatherContent) {
        this.weatherContent = weatherContent;
        this.notifyObservers();
    }
}
