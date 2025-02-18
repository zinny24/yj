package com.example.comment.v3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/v3/view1")
    public String getView1() {
        return "v3/hello";
    }

}
