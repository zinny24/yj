package com.example.yangjung.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex5Controller {


    @GetMapping("/ex5")
    public String getFrmData() {
        return "ajax/ex5";
    }

    @PostMapping("/exData5")
    @ResponseBody
    public String postFrmData(
            @RequestParam String userid,
            @RequestParam String passwd,
            @RequestParam String username) {

        return "아이디 : "+userid+", 비밀번호 : "+passwd+", 이름 : " + username;
    }

}
