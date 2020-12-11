package com.controller;

import com.bean.user;
import com.service.LoginService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "/backuser",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public user backuser(){
        System.out.println("controller:"+loginService.selectuser(1));
        return loginService.selectuser(1);
    }

    @RequestMapping(value = "/login",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String login(String username,String password){
        System.out.println("username="+username+"-----password="+password);
        if(username==null){
            System.out.println(111);
            return "username";
        }else if(password==null){
            System.out.println(222);
            return "password";
        }else if(username!=null&&password!=null){
            System.out.println(555);
            if(loginService.checkuser(username,password)){
                System.out.println(333);
                return "true";
            }else{
                System.out.println(444);
                return "false";
            }

        }
        System.out.println(666);
        return "login";
    }

    @RequestMapping("/login1")
//    @ResponseBody
    public String login1(){
        return "login";
    }

    @RequestMapping("/logintest")
//    @ResponseBody
    public String logintest(){
        return "logintest";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
}
