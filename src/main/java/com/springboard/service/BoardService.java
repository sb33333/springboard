package com.springboard.service;

import com.springboard.dto.BoardDto;
import com.springboard.repository.BoardRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Transactional
public class BoardService {

    private BoardRepository repository;
    public BoardService(BoardRepository repository) {
        this.repository = repository;
    }

    public List<BoardDto> selectBoardList() {
        return repository.findValidBoard();
    }

    public BoardDto writeBoard(BoardDto boardDto) {
        repository.save(boardDto);
        return boardDto;
    }

    public BoardDto selectBoardByIdx(int idx) {
        return repository.findByIdx(idx);
    }

    public BoardDto updateCount(BoardDto boardDto) {
        BoardDto savedDto = repository.findByIdx(boardDto.getBoardIdx());
        savedDto.setHitCnt(savedDto.getHitCnt() + 1);
        return savedDto;
    }

    public BoardDto amendBoard(BoardDto boardDto) {
        BoardDto savedDto = repository.findByIdx(boardDto.getBoardIdx());
        savedDto.setUpdatorId("admin");
        savedDto.setUpdatedDateTime(LocalDateTime.now());
        savedDto.setTitle(boardDto.getTitle());
        savedDto.setContents(boardDto.getContents());
        return savedDto;
    }

    public void deleteBoard(BoardDto boardDto) {
        BoardDto savedDto = repository.findByIdx(boardDto.getBoardIdx());
        savedDto.setUpdatorId("admin");
        savedDto.setUpdatedDateTime(LocalDateTime.now());
        savedDto.setDeletedYn(true);
    }
}
