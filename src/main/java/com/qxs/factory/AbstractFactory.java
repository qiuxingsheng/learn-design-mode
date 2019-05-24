package com.qxs.factory;

public class AbstractFactory {
    public static void main(String [] args){
        //纽约风味的奶酪披萨
        MaterialFactory f = new NYMaterialFactory();
        Pissa ny = new CheesePissa(f);
        ny.prepare();
        ny.info();
        //北京风味奶酪披萨
        MaterialFactory fBj = new BJMaterialFactory();
        Pissa bj = new CheesePissa(fBj);
        bj.prepare();
        bj.info();
    }
}
//披萨基类
abstract class Pissa{
    String name;
    Cheese cheese;
    Milk milk;
    abstract void prepare();
    void info(){
       cheese.name();
       milk.name();
    }
}
//奶酪披萨
class CheesePissa extends Pissa{
    MaterialFactory f;
    public CheesePissa(MaterialFactory f){
        this.f = f;
    }
    void prepare() {
        super.cheese = f.createCheese();
        super.milk = f.createMilk();
    }
}
//抽象工厂接口 用于创建一族对象
interface MaterialFactory{
    Cheese createCheese();
    Milk createMilk();
}

class NYMaterialFactory implements MaterialFactory{

    public Cheese createCheese() {
        return new NYCheese();
    }

    public Milk createMilk() {
        return new NYMilk();
    }
}
class BJMaterialFactory implements MaterialFactory{
    public Cheese createCheese() {
        return new BJCheese();
    }

    public Milk createMilk() {
        return new BJMilk();
    }
}
abstract class Cheese{
    abstract void name();
}
class NYCheese extends Cheese{
    @Override
    void name() {
        System.out.println("NYCheese");
    }
}
class BJCheese extends Cheese{
    @Override
    void name() {
        System.out.println("BJCheese");
    }
}
abstract class Milk{
    abstract void name();
}
class NYMilk extends Milk{
    @Override
    void name() {
        System.out.println("NYMilk");
    }
}
class BJMilk extends Milk{
    @Override
    void name() {
        System.out.println("BJMilk");
    }
}