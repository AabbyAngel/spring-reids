package com.hsnet.winner.web;

import com.hsnet.winner.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhanggl on 2017/9/6.
 */
@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping(value = "/redis/set")
    public void setString() {
        System.out.println("/redis/set/ok");
        stringRedisTemplate.opsForValue().set("key", "stringValue");
    }

    @GetMapping(value = "/redis/get")
    public void getString() {
        System.out.println("/redis/get/ok");
        String result = stringRedisTemplate.opsForValue().get("key");
        System.out.println("result = " + result);
    }

    @RequestMapping(value = "/redis/set/object", method = RequestMethod.GET)
    public void insertStringObject() {
        User user = new User();
        user.setId(1L);
        user.setName("user1");
        user.setPassword("password1");
        System.out.println("/redis/set/object");
        redisTemplate.opsForValue().set("stringKeyObject", user);
    }

}
