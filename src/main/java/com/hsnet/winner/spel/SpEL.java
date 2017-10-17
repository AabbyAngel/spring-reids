package com.hsnet.winner.spel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanggl on 2017/9/12.
 */
public class SpEL {
    static class OOMObject{}
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
