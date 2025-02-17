package com.example.comment.v2;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommentController {

    @GetMapping("/v2")
    public String v2Home() {
        return "comment";
    }

}
