package com.example.comment.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/comment")
public class CommentApiController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentService commentService;

    //저장
    @PostMapping("/save")
    public Comment saveEntry(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    /*
    @GetMapping("/list")
    public List<Comment> getFindAll() {
        return commentRepository.findAll();
    }
    */

    @GetMapping("/list")
    public ResponseEntity<List<Comment>> getFindAll() {
        List<Comment> entries
                = commentRepository.findAll( Sort.by(Sort.Order.desc("id"))  );
        return ResponseEntity.ok(entries);
    }

    //삭제
    @DeleteMapping("/delete/{entryId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long entryId) {
        commentService.deleteComment(entryId);

        return ResponseEntity.noContent().build();
    }

}
