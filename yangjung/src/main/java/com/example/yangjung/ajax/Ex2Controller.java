package com.example.yangjung.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex2Controller {

    @GetMapping("/ex2")
    public String getEX2() {
        return "ajax/ex2";
    }

    @GetMapping("/exData2")
    @ResponseBody
    public String getMessage() {
        return "양정인력개발 센터에 오신 것을 환영합니다.";
    }

}
