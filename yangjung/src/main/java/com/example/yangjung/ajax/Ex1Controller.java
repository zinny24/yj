package com.example.yangjung.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Ex1Controller {

    @GetMapping("/ex1")
    public String getEx1() {
        return "ajax/ex1";
    }

    //@Controller + @ResponseBody = @RestController
    @GetMapping("/exData1")
    @ResponseBody
    public String getHello() {
        return "Hello, Yangjung";
    }

}
