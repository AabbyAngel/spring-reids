package com.hsnet.winner.proxy;

/**
 * Created by zhanggl on 2017/9/27.
 */
public class Person implements IPerson {
    @Override
    public void doSomething() {
        System.out.println("I want to sell this house");
    }
}
