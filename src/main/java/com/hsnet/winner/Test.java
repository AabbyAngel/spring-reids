package com.hsnet.winner;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhanggl on 2017/10/12.
 */
public class Test {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
        hashMap.put("a", "1");

        HashMap<String, String> map = new HashMap<>();
        map.put("b", "1");
    }
}
