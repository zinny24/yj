package com.example.yangjung.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Ex4Controller {

    @GetMapping("/ex4")
    public String getMapData() {
        return "ajax/ex4";
    }

    @GetMapping("/exData4")
    @ResponseBody
    public Map<String, String> getMap() {

        Map<String, String> map = new HashMap<>();
        map.put("userid", "busan");
        map.put("passwd", "1234");

        return map;
    }

    @GetMapping("/getCity")
    @ResponseBody
    public List<String> getCity() {

        return Arrays.asList(
                "서울특별시",
                "부산광역시",
                "대구광역시",
                "인천광역시",
                "대전광역시",
                "광주광역시",
                "울산광역시");

    }

}
