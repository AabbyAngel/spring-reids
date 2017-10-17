package com.hsnet.winner.chain;

/**
 * Created by zhanggl on 2017/10/13.
 */
public abstract class ConsumerHandler {

    private ConsumerHandler nextHandler;

    public ConsumerHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(ConsumerHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * 责任链模式
     *
     * @param user 申请人
     * @param free 报销金额
     */
    public abstract void doHandler(String user, double free);

    public static void main(String[] args) {
        ProjectHandler projectHandler =new ProjectHandler();
        DeptHandler deptHandler =new DeptHandler();
        GeneralHandler generalHandler =new GeneralHandler();
        projectHandler.setNextHandler(deptHandler);
        deptHandler.setNextHandler(generalHandler);
        projectHandler.doHandler("lwx", 450);
        projectHandler.doHandler("lwx", 600);
        projectHandler.doHandler("zy", 600);
        projectHandler.doHandler("zy", 1500);
        projectHandler.doHandler("lwxzy", 1500);

    }
}

//项目经理
class ProjectHandler extends ConsumerHandler {

    @Override
    public void doHandler(String user, double free) {
        if (free < 500) {
            if (user.equals("lwx")) {
                System.out.println("给予报销:" + free);
            } else {
                System.out.println("报销不通过");
            }

        } else {
            if (getNextHandler() != null) {
                getNextHandler().doHandler(user, free);
            }
        }

    }
}

//部门经理
class DeptHandler extends ConsumerHandler {

    @Override
    public void doHandler(String user, double free) {
        if (free < 1000) {

            if (user.equals("zy")) {
                System.out.println("给予报销:" + free);
            } else {
                System.out.println("报销不通过");
            }

        } else {
            if (getNextHandler() != null) {

                getNextHandler().doHandler(user, free);
            }
        }

    }
}

//总经理
class GeneralHandler extends ConsumerHandler {
    @Override
    public void doHandler(String user, double free) {
        if (free >=1000) {

            if (user.equals("lwxzy")) {
                System.out.println("给予报销:" + free);
            } else {
                System.out.println("报销不通过");
            }

        } else {
            if (getNextHandler() != null) {

                getNextHandler().doHandler(user, free);
            }
        }
    }
}

