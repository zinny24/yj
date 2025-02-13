package com.example.yangjung.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UploadController {

    @GetMapping("/upload")
    public String viewUpload() {
        return "ajax/upload";
    }

    @PostMapping("/uploadFile")
    @ResponseBody
    public String doUploadFile(@RequestParam MultipartFile file) {

        String fileOriName = file.getOriginalFilename();

        if (file.isEmpty()) {
            return "업로드할 파일을 선택하세요.";
        }


        return "업로드 된 파일은 " + fileOriName + "입니다.";
    }


}
