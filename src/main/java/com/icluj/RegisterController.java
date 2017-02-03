package com.icluj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by g on 11.01.2017.
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String getRegisterPage(){
        User user = new User();
        user.setEmail("alex@isdc.eu");
        user.setNickname("alex");
        user.setPassword("password");
//        userDAO.save(user);
        userService.saveUser(user);
        return "views/register_page.html";
    }
    @RequestMapping(value="/saveUser", method= RequestMethod.POST)
    public void saveUser(@RequestBody User user){
        System.out.println(user.getEmail());

    }
}

