package gr.dataverse.react.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

//    @RequestMapping("/view")
//    public String getDashboardView(){
//        return "redirect:/view";
//    }

    //implementing a catch all Route and let React handle
    //and parse the URL changes!!!

    @RequestMapping("/")
    public String getHomePage(){
        return "redirect:/index";
    }
}
