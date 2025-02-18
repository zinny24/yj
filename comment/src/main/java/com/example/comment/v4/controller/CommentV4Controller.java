package com.example.comment.v4.controller;

import com.example.comment.v2.CommentService;
import com.example.comment.v4.entity.CommentEntity;
import com.example.comment.v4.respository.CommentRepsi;
import com.example.comment.v4.service.CommentServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v4/comment")
public class CommentV4Controller {

    @Autowired
    private CommentServ commentServ;

    @PostMapping("/save")
    public void saveComment(@RequestBody Map<String, Object> map) {

        String writer   = map.get("writer").toString();
        String content  = String.valueOf( map.get("content") );
        Integer articleId = (Integer) map.get("articleId");

        commentServ.saveCommentEntity(writer, content, articleId);

    }

}
