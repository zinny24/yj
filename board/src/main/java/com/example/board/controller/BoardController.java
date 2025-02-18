package com.example.board.controller;


import com.example.board.entity.Board;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public String list(Model model) {
        List<Board> boards = boardService.getAllBoards();
        model.addAttribute("boards", boards);
        return "list";
    }

    @GetMapping("/new")
    public String newBoard() {
        return "form";
    }

    @PostMapping("/save")
    public String saveBoard(Board board) {
        boardService.saveBoard(board);
        return "redirect:/board";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Board board = boardService.getBoard(id);
        model.addAttribute("board", board);
        return "detail";
    }
}
