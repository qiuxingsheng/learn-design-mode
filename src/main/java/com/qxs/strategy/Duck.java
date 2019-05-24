package com.qxs.strategy;

//鸭子父类
public abstract class Duck {
    FlyBehavior flyBehavior;//飞行能力的接口
    public abstract void fly(); //将飞行方法抽象 由子类进行实现
    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }

    public static void main(String [] args){
        Duck duck = new RedDuck();
        duck.fly();
        duck.setFlyBehavior(new FlyNoWay()); //动态更改对象行为
        duck.fly();
    }
}

class RedDuck extends Duck{

    public RedDuck(){
        this.flyBehavior = new FlyWithWings();
    }

    public void fly() {
        flyBehavior.fly();
    }
}

interface FlyBehavior{
    void fly();
}

class FlyWithWings implements FlyBehavior{
    public void fly() {
        System.out.println("i can fly");
    }
}
class FlyNoWay implements FlyBehavior{
    public void fly() {
        System.out.println("i can not fly");
    }
}