package com.example.yangjung.restapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

class Member {

    @JsonProperty
    private String userid;

    @JsonProperty
    private String passwd;

    @JsonProperty
    private String username;

    public Member(String userid, String passwd, String username) {
        this.userid = userid;
        this.passwd = passwd;
        this.username = username;
    }
}

@RestController
@RequestMapping("/api/v2")
public class RestV2Controller {

    @GetMapping("/user")
    public Map<String, String> getUser() {

        Map<String, String> user = new HashMap<>();
        user.put("userid", "yangjung");
        user.put("passwd", "1234");

        return user;

    }


    //학생번호, {아이디, 비밀번호, 이름}
    @GetMapping("/members")
    public Map<Integer, Member> getMember() {

        Map<Integer, Member> members = new HashMap<>();

        members.put(1, new Member("busan","1234","부산"));
        members.put(2, new Member("seoul", "4321", "서울"));

        return members;

    }

}
