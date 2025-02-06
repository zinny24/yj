package com.example.board.controller;

import com.example.board.entity.Board;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("/board/list")
    public String getBoardList(Model model) {
        model.addAttribute("list", service.getBoardList());
        return "board/board_list";
    }

    @GetMapping("/board/create")
    public String getBoardForm() {
        return "board/board_form";
    }

    @PostMapping("/board/create")
    public String saveBoardCreate(@ModelAttribute Board board) {
        service.getBoardFormData(board);
        return "redirect:/board/list";
    }
}
