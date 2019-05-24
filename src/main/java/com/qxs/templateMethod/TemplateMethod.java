package com.qxs.templateMethod;

public class TemplateMethod {
    public static void main(String[] args) {
        Cook ribs = new CookRibs();
        ribs.cook();

        Cook eggs = new CookEggs();
        eggs.cook();
    }
}
abstract class Cook{
    //模板方法 定义了一套标准流程 简化子类代码
    public void cook(){
        buyFood();
        wash();
        //这是个钩子 如果倒油 打开油烟机
        if (ispourOil()){
            openExtractorHood();
        }
        fire();
    }
    //需要子类实现的方法
    abstract void buyFood();
    //这是个钩子 子类可以选择是否重写他
    public boolean ispourOil(){
        return true;
    }
    public void wash(){
        System.out.println("洗菜");
    }
    public void fire(){
        System.out.println("开火做饭");
    }
    public void openExtractorHood(){
        System.out.println("打开吸油烟机");
    }

}
class CookEggs extends Cook{
    void buyFood() {
        System.out.println("买鸡蛋");
    }
    //煮鸡蛋不用开油烟机
    @Override
    public boolean ispourOil() {
        return false;
    }
}

class CookRibs extends Cook{
    void buyFood() {
        System.out.println("买排骨");
    }
}
