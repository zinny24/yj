package com.example.guest.controller;

import com.example.guest.entity.Reply;
import com.example.guest.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @PostMapping("/save")
    public Reply saveReply(@RequestBody Reply reply) {
        return replyService.saveReply(reply);
    }

    @GetMapping("/{boardId}")
    public List<Reply> getReply(@PathVariable Long boardId) {
        return replyService.getFindByIdBoardId(boardId);
    }

}
