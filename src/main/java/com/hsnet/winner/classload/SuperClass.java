package com.hsnet.winner.classload;

/**
 * 被动使用类字段
 * 通过子类引用父类的静态字段，不会导致子类初始化
 * Created by zhanggl on 2017/10/12.
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 12;
}

class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init !");
    }

}


/**
 * 非主动实用类字段
 */


class NotInitialization {
    public static void main(String[] args) {
//        System.out.println(SubClass.value);

        SubClass[] sca = new SubClass[10];
    }

}
