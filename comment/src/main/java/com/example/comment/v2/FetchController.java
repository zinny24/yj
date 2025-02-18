package com.example.comment.v2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FetchController {

    @GetMapping("/fetch")
    public String viewFetch() {
        return "fetch";
    }

}
