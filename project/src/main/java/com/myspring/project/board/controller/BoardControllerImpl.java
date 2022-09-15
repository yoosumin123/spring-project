package com.myspring.project.board.controller;


import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.project.board.service.BoardService;
import com.myspring.project.board.vo.ArticleVO;
import com.myspring.project.member.vo.MemberVO;
import com.sun.source.tree.WhileLoopTree;

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
	
	
	@Override          
	@RequestMapping(value="/board/addNewArticle.do" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception{
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>(); // 글 정보를 저장하기 위한 articleMap을 생성
		Enumeration enu = multipartRequest.getParameterNames(); // 전송된 파라미터를 가져옴
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value= multipartRequest.getParameter(name); // 글쓰기 창에서 전송된 글 정보를 Map에 key/value로 저장.
			articleMap.put(name, value); // articleMap에 저장한다.
		}   
		
		String imageFileName = upload(multipartRequest); // 업로드한 이미지 파일 이름을 가져옴
		HttpSession session = multipartRequest.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member"); // 로그인 시 저장한 'member'를 가져온다.
		String id = memberVO.getId(); // 세션에 저장된 회원 정보로부터 회원 ID를 가져온다.
		articleMap.put("parentNO", 0);
		articleMap.put("id", id);
		articleMap.put("imageFileName", imageFileName); // 회원 ID, 이미지 파일 이름, 부모 글 번호를 articleMap에 저장
		
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try { 
			int articleNO = boardService.addNewArticle(articleMap); // 글 정보가 저장된 articleMap을 Service클래스의 addNewArticle() 메서드로 전달
			if(imageFileName !=null && imageFileName.length() !=0) { // 업로드한 파일이 있을 경우
				File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName); // temp폴더에 있는 imageFileName으로 File 객체 생성
				File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO); // 글 번호로 폴더 생성
				FileUtils.moveFileToDirectory(srcFile, destDir, true); // 글 번호 폴더로 업로드한 파일을 이동시킨다.
			} // 글 정보를 추가한 후 업로드한 이미지 파일을 글 번호로 명명한 폴더로 이동한다.
			
			message = "<script>"; // 새 글을 추가한 후 메시지를 전달
			message += "alert('새 글을 추가했습니다.');";
			message += "location.href='"+multipartRequest.getContextPath()+"/board/listArticles.do'; ";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED); //ResponseEntity를 이용해 HTML 형식으로 전송한다.
		
		} catch (Exception e) {
			File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
			srcFile.delete();
			
			message = "<script>"; // 오류 발생 시 오류 메시지를 전달
			message += "alert('오류가 발생했습니다. 다시 시도해 주세요');');";
			message += "location.href='"
						+multipartRequest.getContextPath()+"/board/articleForm.do'; ";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED); 
			e.printStackTrace();
		}
		return resEnt;
	}
	
	  
	@RequestMapping(value ="/board/*Form.do", method = RequestMethod.GET)
	private ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	
	@RequestMapping(value="/board/viewArticle.do", method=RequestMethod.GET)
	public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO, 
									HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		articleVO = boardService.viewArticle(articleNO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("article", articleVO);
		return mav;
	}
	
	
	@RequestMapping(value="/board/modArticle.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity modArticle(MultipartHttpServletRequest multipartRequest,
										HttpServletResponse response) throws Exception{
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			articleMap.put(name, value);  // 수정창에서 수정한 글 정보를 전송해서 HashMap에 Key,value로 저장
		}
		String imageFileName = upload(multipartRequest); // 수정 파일첨부 시->temp폴더에 임시 업로드->이미지 파일명 얻어온다 
		HttpSession session = multipartRequest.getSession(); // --> 스프링에서는 getSession -> 어노테이션을 이용할 수 있다.
		MemberVO memberVO = (MemberVO) session.getAttribute("member"); // 로그인 시 저장한 "member"를 가져온다
		String id = memberVO.getId(); // 세션에 저장된 회원 정보로부터 회원 ID를 가져온다
		articleMap.put("id", id); 
		articleMap.put("imageFileName", imageFileName); // articleMap에 id와 imageFileName을 key로 저장한다.
		
		String articleNO = (String) articleMap.get("articleNO"); // 글 번호를 가져온다.
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			boardService.modArticle(articleMap);
			if(imageFileName !=null && imageFileName.length()!=0) {
				File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
				File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
				FileUtils.moveFileToDirectory(srcFile, destDir, true);
				
				String originalFileName = (String)articleMap.get("originalFileName");
				File oldFile = new File(ARTICLE_IMAGE_REPO+"\\"+articleNO+"\\"+originalFileName);
				oldFile.delete();
			}
			message = "<script>";
			message += " alert('글을 수정했습니다.');";
			message += " location.href='"+multipartRequest.getContextPath()+"/board/viewArticle.do?articleNo="+articleNO+"';";
			message += "<script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imageFileName);
			srcFile.delete();
			message = "<script>";
			message += " alert('오류가 발생했습니다.다시 수정해주세요');";
			message += " location.href='"+multipartRequest.getContextPath()+"/board/viewArticle.do?articleNo="+articleNO+"';";
			message += "<script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		return resEnt;
	}
	
	
	// BoardControllerImpl내에서만 사용되는 메소드
	private String upload(MultipartHttpServletRequest multipartRequest) throws Exception{
		String imageFileName = null;
		Map<String, String> articleMap = new HashMap<String, String>();
		Iterator<String> fileNames = multipartRequest.getFileNames();
		
		while (fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			imageFileName = mFile.getOriginalFilename();
			File file = new File(ARTICLE_IMAGE_REPO +"\\" + fileName);
			if(mFile.getSize()!=0) { // File Null Check
				if(! file.exists()) { // 경로상에 파일이 존재하지 않을 경우
					if(file.getParentFile().mkdirs()) { // 경로에 해당하는 디렉토리를 생성
						file.createNewFile(); // 이후 파일 생성
					}
				}
				mFile.transferTo(new File(ARTICLE_IMAGE_REPO +"\\"+"temp"+"\\"+imageFileName)); //임시로 ...
			}
		}
		return imageFileName;
	}

}
