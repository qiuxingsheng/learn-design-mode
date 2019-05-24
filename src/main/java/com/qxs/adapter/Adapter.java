package com.qxs.adapter;

public class Adapter {
    public static void main(String[]args){
        Fish fish = new Fish();
        Run f = new DuckAdapter(fish);
        f.run();
    }
}
interface Run{
    void run();
}
class Fish{
    void swim(){
        System.out.println("我是在游泳");
    }
}
class DuckAdapter implements Run{
    Fish f;
    public DuckAdapter(Fish f){
        this.f = f;
    }

    public void run() {
        f.swim();
    }
}
class Duck implements Run{
    public void run(){
        System.out.println("我是在飞奔");
    }
}
