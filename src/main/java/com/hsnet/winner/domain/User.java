package com.hsnet.winner.domain;

/**
 * Created by zhanggl on 2017/9/6.
 */
public class User {

    private String name;

    private Long id;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
