package com.example.board.service;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository rep;

    public void getBoardFormData(Board board) {
        rep.save(board);
    }

    public List<Board> getBoardList() {
        return rep.findAll( Sort.by(Sort.Order.desc("id"))  );
    }

}
