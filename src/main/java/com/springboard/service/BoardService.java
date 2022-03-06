package com.springboard.service;

import com.springboard.dto.BoardDto;
import com.springboard.repository.BoardRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BoardService {

    private BoardRepository repository;
    public BoardService(BoardRepository repository) {
        this.repository = repository;
    }

    public List<BoardDto> selectBoardList() {
        return repository.findAll();
    }

    public BoardDto writeBoard(BoardDto boardDto) {
        repository.save(boardDto);
        return boardDto;
    }

    public BoardDto selectBoardByIdx(int idx) {
        return repository.findByIdx(idx);
    }
}
