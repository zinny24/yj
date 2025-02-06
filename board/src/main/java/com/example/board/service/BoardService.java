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


    public Board getBoardOne(Long id) {
        return rep.findById(id).orElse(null);
    }

    public void deleteBoard(Long id) {
        rep.deleteById(id);
    }

    //제목으로 검색
    public List<Board> findBySubjectContaining(String subject) {
        return rep.findBySubjectContaining(subject);
    }


    //작성자로 검색
    public List<Board> findByWriterContaining(String writer) {
        return rep.findByWriterContaining(writer);
    }

}
