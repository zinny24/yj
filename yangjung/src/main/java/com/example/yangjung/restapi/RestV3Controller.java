package com.example.yangjung.restapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


class People {
    @JsonProperty
    private Integer stdNum;

    @JsonProperty
    private String stdID;

    @JsonProperty
    private String stdPwd;

    @JsonProperty
    private String stdHome;

    public People(Integer stdNum, String stdID, String stdPwd, String stdHome) {
        this.stdNum = stdNum;
        this.stdID = stdID;
        this.stdPwd = stdPwd;
        this.stdHome = stdHome;
    }
}


@RestController
@RequestMapping("/api/v3")
public class RestV3Controller {

    @GetMapping("/user")
    public Map<Integer, String> getUser() {

        Map<Integer, String> user = new HashMap<>();
        user.put(20, "홍길동");

        return user;
    }

    @GetMapping("/member")
    public List<String> getMember() {

        List<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("김영희");
        list.add("이철수");

        return list;
    }

    @GetMapping("/mem")
    public List<String> getNewMember() {

        return Arrays.asList("RED", "GREEN", "BLUE");
    }


    @GetMapping("/people")
    public List<People> getPeople() {

        List<People> p = new ArrayList<>();
        p.add(new People(1, "busan", "1234", "부산광역시"));
        p.add(new People(2, "seoul", "7777", "서울특별시"));

        return p;

    }

}
