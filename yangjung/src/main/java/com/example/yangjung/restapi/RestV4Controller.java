package com.example.yangjung.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

class User {
    private String userid;
    private String passwd;
    private Integer age;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

@RestController
@RequestMapping("/api/v4")
public class RestV4Controller {

    @PostMapping("/status")
    public ResponseEntity<String> statusResponse(@RequestBody String message) {

        if(  message.isEmpty()  ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Message Provided.");

        }else{
            return ResponseEntity.status(HttpStatus.OK).body("Receive : " + message);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody User user) {

        if( user != null ) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("아이디 : " + user.getUserid()
                            + ", 비밀번호 : " + user.getPasswd() + ", 나이 : " + user.getAge());

        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Receive..");
        }
    }

}
