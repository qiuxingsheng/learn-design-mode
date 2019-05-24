package com.qxs.state;

public class StateShow {

    public static void main(String[] args) {
        GumballMachine gm = new GumballMachine(100);
        gm.insertQuarter();
        gm.ejectQuarter();

    }
}
//投币式糖果机
class GumballMachine{
    State noQuarterState;
    State hasQuarterState;

    State state = noQuarterState;
    int count = 0;

    public GumballMachine(int gumballAmount){
        count = gumballAmount;
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        state = noQuarterState;
    }
    //将此处各种状态的if else省去
    public void setState(State state){
        this.state = state;
    }
    public void insertQuarter(){
        state.insertQuarter();
    }
    public void ejectQuarter(){
        state.ejectQuarter();
    }
    public void turnCrank(){
        state.turnCrank();
        state.dispense();
    }

}

//状态接口 将每个行为根据状态的if else 逻辑判断移到对象的实例中 每个实例只处理本状态下的逻辑
interface State{
    void insertQuarter();//插入硬币
    void ejectQuarter(); //退回硬币
    void turnCrank();//转动摇杆
    void dispense();//分配糖果
}
//未投币状态
class NoQuarterState implements State{
    GumballMachine gm;
    public NoQuarterState(GumballMachine gm){
        this.gm = gm;
    }
    @Override
    public void insertQuarter() {
        System.out.println("您投入25分硬币");
        //状态改为hasQuarter
        gm.setState(gm.hasQuarterState);
    }

    @Override
    public void ejectQuarter() {
        System.out.println("你还没投币");
    }

    @Override
    public void turnCrank() {
        System.out.println("你还没投币");
    }

    @Override
    public void dispense() {
        System.out.println("你还没投币");
    }
}
//已投币状态
class HasQuarterState implements State{
    GumballMachine gm;
    public HasQuarterState(GumballMachine gm){
        this.gm = gm;
    }
    @Override
    public void insertQuarter() {
        System.out.println("你已投币,不需要重复投币");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("硬币退回");
    }

    @Override
    public void turnCrank() {
        System.out.println("拉下摇杆，状态改为开始出糖果");

    }

    @Override
    public void dispense() {
        System.out.println("请拉下摇杆");
    }
}