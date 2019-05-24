package com.qxs.factory;

public class FactoryMethod {

    public static void main(String[]args){
        PizzaStore ny = new NYPizzaStore();
        ny.createPizza("Cheese").name();
        ny.createPizza("Clam").name();
    }
}

abstract class PizzaStore{
    abstract Pizza createPizza(String type);
}
class NYPizzaStore extends PizzaStore{
    Pizza createPizza(String type) {
        if("Cheese".equals(type)){
            return new NYStyleCheesePizz();
        }else if ("Clam".equals(type)){
            return new NYStyleClamPizz();
        }
        return null;
    }
}
class BJPizzaStore extends PizzaStore{
    Pizza createPizza(String type) {
        if("Cheese".equals(type)){
            return new BJStyleCheesePizz();
        }else if ("Clam".equals(type)){
            return new BJStyleClamPizz();
        }
        return null;
    }
}
abstract class Pizza{
    abstract void name();
}
class NYStyleCheesePizz extends Pizza{
    void name(){
        System.out.println("NYStyleCheesePizz");
    }
}
class NYStyleClamPizz extends Pizza{
    void name(){
        System.out.println("NYStyleClamPizz");
    }
}
class BJStyleCheesePizz extends Pizza{
    void name(){
        System.out.println("BJStyleCheesePizz");
    }
}
class BJStyleClamPizz extends Pizza{
    void name(){
        System.out.println("BJStyleClamPizz");
    }
}
