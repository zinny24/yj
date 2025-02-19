package com.example.guest.service;


import com.example.guest.entity.Board;
import com.example.guest.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> getAllBoards() {
        return boardRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    public void saveBoard(Board board) {
        boardRepository.save(board);
    }

    public Board getBoard(Long id) {
        return boardRepository.findById(id).orElse(null);
    }
}

