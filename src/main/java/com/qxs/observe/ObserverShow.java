package com.qxs.observe;

import java.util.ArrayList;
import java.util.List;

public class ObserverShow {
    public static void main(String[]args){
        Subject s = new WeatherDataSubject();
        Observer tv = new TvObserver();
        Observer mobile = new MobileObserver();
        s.addObserver(tv);
        s.addObserver(mobile);
        s.notifyObserver();
        s.removeObserver(tv);
        s.notifyObserver();
    }
}

interface Subject{
    void addObserver(Observer o);//添加观察者
    void removeObserver(Observer o);//移除观察者
    void notifyObserver();//通知观察者 调用观察者的update()
}
interface Observer{
    void update();
}
class WeatherDataSubject implements  Subject{
    private List<Observer> observers = new ArrayList<Observer>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObserver() {
        for (Observer o : observers){
            o.update();
        }
    }
}

class TvObserver implements Observer{

    public void update() {
        System.out.println("电视台刚刚收到消息，气温骤降");
    }
}
class MobileObserver implements Observer{

    public void update() {
        System.out.println("移动气象站刚刚收到消息，气温骤降");
    }
}