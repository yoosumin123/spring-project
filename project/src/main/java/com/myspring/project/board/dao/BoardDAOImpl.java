package com.myspring.project.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.project.board.vo.ArticleVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllArticlesList() throws DataAccessException{ // id가 selectAllArticlesList인 SQL문을 요청한다.
		List<ArticleVO> articlesList = articlesList = sqlSession.selectList("mapper.board.selectAllArticlesList");
		return articlesList;
	}
	
	public int insertNewArticle(Map articleMap) throws DataAccessException{
		int articleNO = selectNewArticleNO(); // 추가할 글의 글 번호를 얻어온다.
		articleMap.put("articleNO", articleNO); // articleMap에 articleNO로 글 번호를 저장한다.
		sqlSession.insert("mapper.board.insertNewArticle", articleMap); // board.xml에 해당 id의 sql문으로 articleMap을 전달 
		return articleNO; // 업로드한 파일을 저장할 폴더명을 만들기 위해 글 번호를 controller로 반환한다.
	}
	
	private int selectNewArticleNO() throws DataAccessException{ // 글 번호 얻어오는 메소드 
		return sqlSession.selectOne("mapper.board.selectNewArticleNO");
	}
}
