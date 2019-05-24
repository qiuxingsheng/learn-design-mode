package com.qxs.command;

public class Order {
    public void orderUp(){
        System.out.println("order up");
    }
    public void createOrder(){
        System.out.println("createOrder");
    }
}

interface OrderCommand{
    void execute();
}

class OrderUpCommand implements OrderCommand{
    Order o;
    public OrderUpCommand(Order o){
        this.o = o;
    }
    public void execute() {
        o.orderUp();
    }
}
class OrderCreateCommand implements OrderCommand{
    Order o;
    public OrderCreateCommand(Order o){
        this.o = o;
    }
    public void execute() {
        o.createOrder();
    }
}
class Vitor{
    OrderCommand oc;
    public void setOrderCommand(OrderCommand oc){
        this.oc = oc;
    }

    public void receiveOrder(){
        oc.execute();
    }
}
class Client{
    OrderCommand oc;
    public void setOrderCommand(OrderCommand oc){
        this.oc = oc;
    }

    public void createOrder(){
        oc.execute();
    }
}