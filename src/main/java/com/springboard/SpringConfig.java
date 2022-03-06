package com.springboard;


import com.springboard.repository.BoardRepository;
import com.springboard.service.BoardService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;
    private EntityManager em;

    public SpringConfig (DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public BoardService boardService() {
        return new BoardService(boardRepository());
    }

    public BoardRepository boardRepository() {
        return new BoardRepository(em);
    }



}
