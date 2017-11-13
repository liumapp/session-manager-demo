package com.liumapp.web.controller;

import com.liumapp.web.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by liumapp on 11/13/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 * Redis的测试Demo
 */
@RestController
@RequestMapping("/redis")
public class RedisDemoController {

    @Autowired
    private RedisTemplate<String , String> redisTemplate;

    @Resource(name = "redisTemplate")
    private ListOperations<String , String> listOps;

    /**
     * leftPush的Demo
     * @param name
     * @param sex
     * @return
     */
    @GetMapping("push")
    public String pushGuest (String name , String sex) {
        listOps.leftPush("name" , name);
        listOps.leftPush("sex" , sex);
        return "success";
    }

    /**
     * 与leftPush相对应的leftPop
     * @return
     */
    @GetMapping("pop")
    public String popGuest () {
        String name = listOps.leftPop("name");
        String sex = listOps.leftPop("sex");
        Guest guest = new Guest(name , sex);
        return guest.toString();
    }

}
