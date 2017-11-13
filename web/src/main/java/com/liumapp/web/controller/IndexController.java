package com.liumapp.web.controller;

import com.liumapp.web.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liumapp on 10/9/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private Guest guest;

    @GetMapping("/")
    public String index (ModelMap modelMap) {

        guest.setName("jony");
        guest.setName("boy");

        modelMap.addAttribute("name" , guest.getName());
        modelMap.addAttribute("sex" , guest.getSex());

        return "index";

    }

    @PostMapping("/add")
    public String add (Guest guest) {
        return "redirect:/";
    }



}
