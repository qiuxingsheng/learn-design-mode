package com.qxs.proxy;

/**
 * 静态代理
 * @author qiuxs
 **/
public class StaticProxy {

    public static void main(String[] args) {

        SuperStar b = new Broker(new Singer());
        b.signContract();
    }
}

/**
 * 明星
 */
interface SuperStar{
    /**
     * 签合同
     */
    void signContract();
}

/**
 * 歌星
 */
class Singer implements SuperStar{

    @Override
    public void signContract() {
        System.out.println("1年1亿合同");
    }
}

/**
 * 经纪人
 */
class Broker implements SuperStar{
    SuperStar ss;

    public Broker(SuperStar ss) {
        this.ss = ss;
    }

    @Override
    public void signContract() {
        System.out.println("我是经济人 本来要签2亿的 给你便宜点");
        ss.signContract();
    }
}


