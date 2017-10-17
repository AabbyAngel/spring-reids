package com.hsnet.winner.chain;

/**
 * Created by zhanggl on 2017/10/13.
 */
public abstract class Handler {

    private Handler nextHandler;

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void doHandler();
}

class ConcreteHandler extends Handler{

    @Override
    public void doHandler() {
        if(getNextHandler() != null){
            System.out.println("还有责任链");
            getNextHandler().doHandler();
        }else {
            System.out.println("我已经处理了。");
        }
    }
}
