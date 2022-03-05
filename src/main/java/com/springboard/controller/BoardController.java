package com.springboard.controller;

import com.springboard.dto.BoardDto;
import com.springboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BoardController {

    private final BoardService service;

    public BoardController(BoardService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toMain() {
        return "redirect:/board";
    }

    //  게시글 목록 창 불러오기
    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public ModelAndView boardList() {
        ModelAndView mv = new ModelAndView("/board/boardList");
        List<BoardDto> result = service.selectBoardList();
        mv.addObject("list",result);
        return mv;
    }

    //    게시글 작성 창 불러오기
    @RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
    public String openBoardWrite(Model model) {
        model.addAttribute("dto", new BoardDto());
        return "/board/boardWrite";
    }

    //    새 게시글 저장하기
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String insertBoard(@ModelAttribute("dto") BoardDto boardDto) {
        boardDto.setCreatorId("admin");
        boardDto.setCreatedDateTime(LocalDateTime.now());
        System.out.println(boardDto.toString());
        service.writeBoard(boardDto);
        return "redirect:/";
    }


}
