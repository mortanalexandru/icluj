package com.icluj;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by g on 11.01.2017.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String getLogin(){
        return "views/login_page.html";

    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    @ResponseBody
    public boolean login(@RequestBody UserJSON user){
        System.out.println(user.getEmail());
        return userService.login(user);


    }
}
