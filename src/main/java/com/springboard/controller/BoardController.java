package com.springboard.controller;

import com.springboard.dto.BoardDto;
import com.springboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService service;


    @RequestMapping("/board/board-list")
    public ModelAndView boardList() {
        ModelAndView mv = new ModelAndView("/board/boardList");
        List<BoardDto> result = service.selectBoardList();
        mv.addObject("list",result);
        return mv;
    }
}
