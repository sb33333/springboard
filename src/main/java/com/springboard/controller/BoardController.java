package com.springboard.controller;

import com.springboard.dto.BoardDto;
import com.springboard.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BoardController {

    private final BoardService service;
    private Logger log = LoggerFactory.getLogger(this.getClass());

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
        ModelAndView mv = new ModelAndView("board/boardList");
        log.warn("boardList");
        List<BoardDto> result = service.selectBoardList();
        mv.addObject("list",result);
        return mv;
    }

    //    게시글 작성 창 불러오기
    @RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
    public String openBoardWrite(Model model) {
        model.addAttribute("dto", new BoardDto());
        return "board/boardWrite";
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

//    게시글 내용 열기
    @RequestMapping(value = "/board/{idx}", method = RequestMethod.GET)
    public String readArticle(@PathVariable int idx, Model model) {
        BoardDto result = service.selectBoardByIdx(idx);
        model.addAttribute("board", result);
        service.updateCount(result);
        return "board/boardContent";
    }

//    게시글 수정하기
    @RequestMapping(value = "/board/update", method = RequestMethod.POST)
    public String updateArticle(@ModelAttribute("frm") BoardDto boardDto) {
        service.amendBoard(boardDto);
        return "redirect:/";
    }

//    게시글 삭제하기
    @RequestMapping(value = "/board/delete", method = RequestMethod.POST)
    public String deleteArticle (@ModelAttribute("frm") BoardDto boardDto) {
        service.deleteBoard(boardDto);
        return "redirect:/";
    }
}
