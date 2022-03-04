package com.springboard.controller;

import com.springboard.dto.BoardDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

    @RequestMapping("/board/board-list")
    public ModelAndView boardList() {
        ModelAndView mv = new ModelAndView("/board/boardList");
//        List<BoardDto> result = boardService
//        mv.addObject();
        return mv;
    }
}
