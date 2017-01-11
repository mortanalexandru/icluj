package com.icluj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by g on 11.01.2017.
 */
@Controller
public class RegisterController {
    @RequestMapping("/register")
    public String getRegisterPage(){
        return "views/register_page.html";
    }

}
