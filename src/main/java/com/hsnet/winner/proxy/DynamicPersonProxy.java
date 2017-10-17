package com.hsnet.winner.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 它的好处理时可以为我们生成任何一个接口的代理类，
 * 并将需要增强的方法织入到任意目标函数。但它仍然具有一个局限性，
 * 就是只有实现了接口的类，才能为其实现代理。
 * Created by zhanggl on 2017/9/27.
 */
public class DynamicPersonProxy implements InvocationHandler {

    private Object delegate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("Before Proxy");
        Object result = method.invoke(delegate, args);
        logger.info("After Proxy");
        return result;
    }

    public static void main(String[] args) {
        DynamicPersonProxy dynamicPersonProxy = new DynamicPersonProxy();
        IPerson ip = (IPerson) dynamicPersonProxy.bind(new Person());
        ip.doSomething();

    }


}
