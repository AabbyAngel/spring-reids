package com.hsnet.winner.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhanggl on 2017/9/27.
 */
public class FinalPersonProxy {

    private final static Logger logger = LoggerFactory.getLogger(FinalPersonProxy.class);

    private IPerson iPerson;

    public FinalPersonProxy(IPerson iPerson){
        this.iPerson = iPerson;
    }
    public void doSomething(){
        logger.info("Before Proxy");
        iPerson.doSomething();
        logger.info("After Proxy");
    }

    public static void main(String[] args) {
        FinalPersonProxy personProxy = new FinalPersonProxy(new Person());
        personProxy.doSomething();
    }


}
