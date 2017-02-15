package com.icluj;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by g on 25.01.2017.
 */
@Controller
public class ProfilePageController {
    @RequestMapping("/profile")
    public String getProfilePage(){return "views/profile_page.html";}
}
