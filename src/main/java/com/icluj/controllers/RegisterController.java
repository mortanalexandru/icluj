package com.icluj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icluj.json.UserJSON;
import com.icluj.services.UserService;

/**
 * Created by g on 11.01.2017.
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String getRegisterPage(){
        return "register_page";
    }
    @RequestMapping(value="/saveUser", method= RequestMethod.POST)
    public void saveUser(@RequestBody UserJSON user){
        System.out.println(user.getEmail());
        //userService.saveUser(user);
    }
}

