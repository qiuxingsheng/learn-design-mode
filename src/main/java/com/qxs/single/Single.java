package com.qxs.single;

public class Single {
    private static Single single;
    private Single(){}
    public static Single getInstance(){
        if(single == null){
            single = new Single();
            return single;
        }
        return single;
    }
}

class Single2{
    private static Single2 single = new Single2();
    private Single2(){}
    public static Single2 getInstance(){

        return single;
    }
}

class Single3{
    private static volatile Single3 s ;
    private Single3(){}
    public static Single3 getInstance(){
        if(s==null){
            synchronized (Single3.class){
                if (s == null){
                    s = new Single3();
                }
            }
        }

        return s;
    }
}
