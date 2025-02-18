package com.example.comment.v2;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public void deleteComment(Long entryId) {
        commentRepository.deleteById(entryId);
    }

}
