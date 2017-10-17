package com.hsnet.winner.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB解决了动态代理的难题，它通过生成目标类子类的方式来实现代理，
 * 而不是接口，规避了接口的局限性。
 * CGLIB是一个强大的高性能代码生成包，其在运行时期（非编译时期）生成被代理对象的子类
 * 并重写了被代理对象的所有方法，从而作为代理对象。
 * Created by zhanggl on 2017/9/27.
 */
public class CglibPersonProxy implements MethodInterceptor {

    private Object delegate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        logger.info("Before Proxy");
        Object result = methodProxy.invokeSuper(method, objects);
        logger.info("After Proxy");
        return result;
    }

    public static Person getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
        enhancer.setCallback(new CglibPersonProxy());
        Person p = (Person) enhancer.create();
        return p;
    }

    public static void main(String[] args) {
        CglibPersonProxy cglibPersonProxy = new CglibPersonProxy();

    }
}
