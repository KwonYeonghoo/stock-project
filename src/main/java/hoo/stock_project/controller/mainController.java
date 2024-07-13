package hoo.stock_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/stock")
@Controller
public class mainController {
    
    @GetMapping("/index")
    public String getIndexPage(){
        return "index";
    }
}
