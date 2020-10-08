package gr.dataverse.react.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @RequestMapping("/view")
    public String getDashboardView(){
        return "redirect:/view";
    }

}
