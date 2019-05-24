package com.qxs.command;

public class CommandShow {

    public static void main(String [] args){
        SimpleRemoteControl c = new SimpleRemoteControl();
        c.setCommand(new LightOnCommand(new Light()));
        c.buttonWasPressed();
    }
}

interface Command{
    void execute();
}

class Light{
    void on(){
        System.out.println("Light on");
    }
    void off(){
        System.out.println("Light off");
    }
}
class LightOnCommand implements Command{
    Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    public void execute() {
        light.on();
    }
}
class SimpleRemoteControl{
    Command slot;
    public SimpleRemoteControl(){}
    public void setCommand(Command c){
        slot = c;
    }
    public void buttonWasPressed(){
        slot.execute();
    }
}