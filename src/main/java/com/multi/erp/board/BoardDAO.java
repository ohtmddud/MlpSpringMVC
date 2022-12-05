package com.multi.erp.board;

import java.util.List;
// MyBatis 의 SqlSession 을 이용해서 작업

public interface BoardDAO {
//	게시글 등록 - DB에 처리
	int insert(BoardDTO board);
	
//	게시글 목록 보기 - DB에 처리
	List<BoardDTO> boardList();
	
//	게시글 상세 조회 - DB에 처리
	BoardDTO read(String board_no);
	
//	게시글 수정 - DB에 처리
	int update(BoardDTO board);
	
//	게시글 삭제 - DB에 처리
	int delete(String board_no);
	
//	게시글 제목으로 검색 - DB에 처리
	List<BoardDTO> search(String data);
	
//	게시글 제목, 작성자, 본문, 작성일 검색 - DB에 처리
	List<BoardDTO> search(String tag, String data);
	
//	카테고리로 검색 - DB에 처리
	List<BoardDTO> findByCategory(String category);

}
