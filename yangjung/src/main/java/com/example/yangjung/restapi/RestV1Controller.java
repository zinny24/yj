package com.example.yangjung.restapi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RestV1Controller {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello, SpringBoot RestAPI";
    }

    @GetMapping("/welcome/{username}")
    public String getWelcome(@PathVariable String username) {
        return "Welcome, " + username;
    }


    @GetMapping("/login/{userid}/{passwd}")
    public String doLogin(
            @PathVariable String userid, @PathVariable String passwd) {

        if( userid.equals("admin") && passwd.equals("1234") ) {
            return "로그인 성공";

        }else{
            return "로그인 실패";
        }

    }

    @GetMapping("/user")
    public String getUser(@RequestParam String username) {
        return "전송 데이터는 " + username + "입니다.";
    }

    @GetMapping("/member")
    public String doMember(@RequestParam String userid,
                           @RequestParam String passwd,
                           @RequestParam(defaultValue = "Seoul") String username) {
        return userid + ", " + passwd + ", " + username;

//        if( userid.equals("admin") && passwd.equals("1111") ) {
//            return "Success...";
//        }else{
//            return "Failure...";
//        }

    }

}







