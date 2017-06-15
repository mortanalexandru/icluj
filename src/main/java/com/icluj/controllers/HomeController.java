package com.icluj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Alexandru on 03/01/2017.
 */
@Controller
public class HomeController {

        @RequestMapping("/")
        public String greeting() {
            return "default";
        }
        
        

}

