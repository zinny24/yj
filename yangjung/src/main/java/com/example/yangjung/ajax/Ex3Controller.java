package com.example.yangjung.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Ex3Controller {

    @GetMapping("/ex3")
    public String getUserid() {
        return "ajax/ex3";
    }

    @PostMapping("/exData3")
    @ResponseBody
    public String getCheckUserid(@RequestParam String userid) {
        System.out.println(userid);

        if( userid.equals("admin") ) {
            return userid + "는 사용하셔도 좋습니다.";

        }else{
            return userid + "는 사용할 수 없습니다.";
        }

    }

}
