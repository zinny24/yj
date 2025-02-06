package com.example.board.controller;

import com.example.board.entity.Board;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("/list")
    public String getBoardList(Model model,
                               @RequestParam(required = false) String searchType,
                               @RequestParam(required = false) String word) {

        List<Board> list = null;

        if(  searchType  != null && word != null && !word.isEmpty() ) {

            if( "subject".equals(searchType) ) {
                list = service.findBySubjectContaining(word);

            }else if( "writer".equals(searchType) ) {
                list = service.findByWriterContaining(word);

            }else{
                list = service.getBoardList();
            }

        }else{
            list = service.getBoardList();
        }

        model.addAttribute("list", list);
        return "board/board_list";
    }

    @GetMapping("/create")
    public String getBoardForm() {
        return "board/board_form";
    }

    @PostMapping("/create")
    public String saveBoardCreate(@ModelAttribute Board board) {
        service.getBoardFormData(board);
        return "redirect:/board/list";
    }

    @GetMapping("/view/{id}")
    public String getBoardView(@PathVariable Long id, Model model) {

        Board result = service.getBoardOne(id);
        model.addAttribute("result", result);
        return "board/board_view";
    }

    @GetMapping("/delete/{id}")
    public String boardDelete(@PathVariable Long id) {
        service.deleteBoard(id);

        return "redirect:/board/list";
    }

}
