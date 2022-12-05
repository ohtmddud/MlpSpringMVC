package com.multi.erp.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOimpl implements BoardDAO {
//	Mybatis 의 핵심 클래스를 이용해서 sql 문을 실행
	SqlSession sqlSession;

	public BoardDAOimpl() {

	}
	@Autowired
	public BoardDAOimpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	@Override
	public int insert(BoardDTO board) {
		return sqlSession.insert("com.multi.erp.board.write", board);
	}

	@Override
	public List<BoardDTO> boardList() {
		return sqlSession.selectList("com.multi.erp.board.selectAll");
	}

	@Override
	public BoardDTO read(String board_no) {
		return sqlSession.selectOne("com.multi.erp.board.read", board_no);
	}

	@Override
	public int update(BoardDTO board) {
		System.out.println(board);
		return sqlSession.update("com.multi.erp.board.update", board);
	}

	@Override
	public int delete(String board_no) {
		return sqlSession.delete("com.multi.erp.board.delete", board_no);
	}
	
	@Override
	public List<BoardDTO> search(String data) {
		return sqlSession.selectList("com.multi.erp.board.search", data);
	}
	@Override
	public List<BoardDTO> search(String tag, String data) {
		return null; 
	}
	@Override
	public List<BoardDTO> findByCategory(String category) {
		return null;
	}

}
