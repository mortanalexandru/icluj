package com.icluj;

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
    @RequestMapping("/register")
    public String getRegisterPage(){
        return "views/register_page.html";
    }
    @RequestMapping(value="/saveUser", method= RequestMethod.POST)
    public void saveUser(@RequestBody User user){
        System.out.println(user.getEmail());

    }
}

