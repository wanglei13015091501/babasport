package com.itheima.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登录控制
 * @Auther: wanglei
 * @Date: 2019.09.19
 * @Description: com.itheima.core.controller
 * @version: 1.0
 */
@Controller
public class LoginController {

    //去登录页面
    @RequestMapping(value = "/login.aspx",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
