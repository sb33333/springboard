package com.springboard.repository;

import com.springboard.dto.BoardDto;

import javax.persistence.EntityManager;
import java.util.List;

public class BoardRepository {

    private final EntityManager em;
    public BoardRepository(EntityManager em) {
        this.em = em;
    }

    public BoardDto save(BoardDto board) {
        em.persist(board);
        return board;
    }

    public List<BoardDto> findAll() {
        return em.createQuery("select board from BoardDto as board", BoardDto.class).getResultList();
    }

    public List<BoardDto> findValidBoard() {
        boolean deleted = false;
        return em.createQuery("select board from BoardDto as board where board.deletedYn =: deleted")
                .setParameter("deleted", deleted).getResultList();
    }

    public BoardDto findByIdx(int idx) {
        return em.find(BoardDto.class, idx);
    }



}
