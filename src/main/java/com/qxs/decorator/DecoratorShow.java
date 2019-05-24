package com.qxs.decorator;

public class DecoratorShow {
    public static void main(String [] args){
        Beverage b = new Espresso();
        System.out.println(b.getDescription()+","+b.cost());
        b = new Milk(b);
        System.out.println(b.getDescription()+","+b.cost());
        b = new Salt(b);
        System.out.println(b.getDescription()+","+b.cost());
    }
}
//饮料基类
abstract class Beverage{
    String description = "unknown Beverage";
    public String getDescription(){
        return description;
    }
    public abstract double cost();
}
//调料装饰基类
abstract class CondimentDecorator extends Beverage{
    public abstract String getDescription();
}
//浓缩咖啡
class Espresso extends Beverage{

    public Espresso(){
        this.description = "Espresso";
    }

    public double cost() {
        return 1;
    }
}
//调料装饰类
class Milk extends CondimentDecorator{

    private Beverage beverage;

    public Milk(Beverage beverage){
        this.beverage = beverage;
    }

    public double cost() {
        return 0.5 + beverage.cost();
    }

    public String getDescription() {
        return beverage.getDescription() + "+ Milk";
    }
}
class Salt extends CondimentDecorator{
    private Beverage beverage;

    public Salt(Beverage beverage){
        this.beverage = beverage;
    }

    public double cost() {
        return 0.3 + beverage.cost();
    }

    public String getDescription() {
        return beverage.getDescription() + "+ Salt";
    }
}