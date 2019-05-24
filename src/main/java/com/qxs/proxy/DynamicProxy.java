package com.qxs.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author qiuxs
 **/
public class DynamicProxy {

    public static void main(String[] args) {
        SuperStar s = (SuperStar) Proxy.newProxyInstance(Singer.class.getClassLoader(), Singer.class.getInterfaces(), new SongZhe(new Singer()));
        s.signContract();

        Wife mr =  (Wife)Proxy.newProxyInstance(MaRong.class.getClassLoader(), MaRong.class.getInterfaces(), new SongZhe(new MaRong()));
        mr.say();
    }
}

class SongZhe implements InvocationHandler {

    private Object target;

    public SongZhe(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("我是经纪人，宋哲");

        method.invoke(target, args);
        return null;
    }
}

interface Wife{
    void say();
}

class MaRong implements Wife{

    @Override
    public void say() {
        System.out.println("老公");
    }
}
