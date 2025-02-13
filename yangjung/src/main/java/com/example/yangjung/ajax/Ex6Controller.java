package com.example.yangjung.ajax;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Ex6Controller {

    @GetMapping("/ex6")
    public String viewTable() {
        return "ajax/ex6";
    }

    @GetMapping("/ex7")
    public String viewTable2() {
        return "ajax/ex7";
    }

    @GetMapping("/exData6")
    @ResponseBody
    public List<Map<String, String>> getTable() {

        List<Map<String, String>> board = new ArrayList<>();

        Map<String, String> board1 = new HashMap<>(); //객체1
        board1.put("subject", "게시판 테스트1");
        board1.put("writer", "관리자");

        Map<String, String> board2 = new HashMap<>(); //객체2
        board2.put("subject", "공지사항 테스트입니다.");
        board2.put("writer", "홍길동");

        board.add(board1);
        board.add(board2);

        return board;
    }


}
