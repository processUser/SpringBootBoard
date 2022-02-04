package com.koreait.springbootboard.board;

import com.koreait.springbootboard.Const;
import com.koreait.springbootboard.board.model.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired BoardService service;

    @GetMapping("/list")
    public void list() {}

    @GetMapping("/detail")
    public void detail() {}

    @GetMapping("/detail_item")
    public void detail_item(Model model, BoardDto dto) {
        model.addAttribute("data", service.selBoard(dto));
    }
}
