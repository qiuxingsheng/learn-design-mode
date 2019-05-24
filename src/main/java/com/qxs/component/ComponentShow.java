package com.qxs.component;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class ComponentShow {

    public static void main(String[] args) {
        MenuComponent menu = new Menu("索菲特");
        MenuComponent topLevel1 = new Menu("山珍");
        topLevel1.add(new MenuItem("熊掌",250));
        topLevel1.add(new MenuItem("燕窝",300));

        MenuComponent secendLevel = new Menu("蔬菜");
        secendLevel.add(new MenuItem("黄瓜",10));
        secendLevel.add(new MenuItem("茄子", 5));
        topLevel1.add(secendLevel);
        MenuComponent topLevel2 = new Menu("海味");

        menu.add(topLevel1);
        menu.add(topLevel2);
        menu.print();
        System.out.println("----------------------------");
        Iterator<MenuComponent> it = menu.createIterator();
        while (it.hasNext()){
            System.out.println(it.next().getName());
        }
    }
}
//菜单组合基类
abstract class MenuComponent{
    public void add(MenuComponent m){
        throw new UnsupportedOperationException();
    }
    public void remove(MenuComponent m){
        throw new UnsupportedOperationException();
    }
    public MenuComponent getChild(int i){
        throw new UnsupportedOperationException();
    }
    public String getName(){
        throw new UnsupportedOperationException();
    }
    public void print(){
        throw new UnsupportedOperationException();
    }
    abstract Iterator<MenuComponent> createIterator();

}
class Menu extends MenuComponent{
    List<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    public Menu(String name){
        this.name = name;
    }

    @Override
    public void add(MenuComponent m) {
        menuComponents.add(m);
    }

    @Override
    public void remove(MenuComponent m) {
        menuComponents.remove(m);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void print(){
        System.out.println(name);
        menuComponents.stream().forEach( item->{item.print();});
    }

    @Override
    Iterator<MenuComponent> createIterator() {
        return new CompositeIterator(menuComponents.iterator());
    }
}

class MenuItem extends MenuComponent{
    String name;
    double price;
    public MenuItem(String name, double price){
        this.name = name;
        this.price = price;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void print(){
        System.out.println("name="+name +",price:"+price);
    }

    @Override
    Iterator<MenuComponent> createIterator() {
        return new NullIterator() ;
    }
}

class CompositeIterator implements Iterator{
    Stack<Iterator<MenuComponent>> stack = new Stack<>();

    public CompositeIterator(Iterator<MenuComponent> iterator){
        stack.push(iterator);
    }


    @Override
    public Object next() {
        if(hasNext()){
            Iterator<MenuComponent> it = stack.peek();
            MenuComponent menu =  it.next();
            if(menu instanceof Menu){
                stack.push(menu.createIterator());
            }
            return menu;
        }
        return null;
    }
    @Override
    public boolean hasNext() {
        if(stack.empty()){
            return false;
        }else{
            Iterator it = stack.peek();
            if(!it.hasNext()){
                stack.pop();
                return hasNext();
            }else{
                return true;
            }
        }
    }

    @Override
    public void remove() {

    }
}
class NullIterator implements Iterator{

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}