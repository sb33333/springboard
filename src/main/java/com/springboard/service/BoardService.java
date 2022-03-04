package com.springboard.service;

import com.springboard.dto.BoardDto;
import com.springboard.repository.BoardRepository;

import java.util.List;

public class BoardService {

    private BoardRepository repository;
    public BoardService(BoardRepository repository) {
        this.repository = repository;
    }

    public List<BoardDto> selectBoardList() {
        return repository.findAll();
    }
}
