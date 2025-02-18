package com.example.comment.v3;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/v3/hello")
    public String getHello() {
        return "Hello, Yangjung...";
    }

    @GetMapping("/v3/jsonData")
    public Map<String, String> getJson() {

        Map<String, String> map = new HashMap<>();
        map.put("userid", "busan");
        map.put("passwd", "1234");

        return map;

    }

    @PostMapping("/v3/saveJson")
    public String saveJson(@RequestBody Map<String, String> map) {

        String userid = map.get("userid");
        String passwd = map.get("passwd");

        if( userid.equals("yangjung") && passwd.equals("1234") ) {
            return "로그인 되었습니다.";
        }else{
            return "사용자 정보를 확인하세요.";
        }
    }

    @DeleteMapping("/v3/deleteJson/{id}")
    public String deleteJson(@PathVariable Long id) {
        return id + "번 게시물이 삭제 되었습니다.";
    }

}
