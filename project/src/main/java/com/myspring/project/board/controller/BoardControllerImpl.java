package com.myspring.project.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.project.board.service.BoardService;
import com.myspring.project.board.vo.ArticleVO;

// Controller 어노테이션을 적용
@Controller("boardController")
public class BoardControllerImpl implements BoardController{
	private static final String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
	// 오토와이어드로 주입
	@Autowired
	BoardService boardService;
	
	@Autowired
	ArticleVO articleVO;
	
	@RequestMapping(value = "/board/listArticles.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception{	                       
		String viewName = (String)request.getAttribute("viewName"); // 인터셉터에서 전달된 뷰이름을 가져온다 
		List articlesList = boardService.listArticles(); // 모든 글 정보를 조회한다.
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articlesList", articlesList); // 조회한 글 정보를 바인딩한 후 JSP로 전달한다
		return mav;
		
		
		
	}

}
