package com.example.guest.service;


import com.example.guest.entity.Reply;
import com.example.guest.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public List<Reply> getFindByIdBoardId(Long boardId) {
        return replyRepository
                .findByBoardId(boardId, Sort.by(Sort.Order.desc("id")));
    }

    public Reply saveReply(Reply reply) {
        return replyRepository.save(reply);
    }

}
