package com.myspring.project.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface BoardController {
	// 전체 글 목록 조회
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception;
	

}
