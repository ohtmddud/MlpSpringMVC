package com.multi.erp.board;

import java.util.List;

public interface BoardService {
//	게시글 등록
	int insert(BoardDTO board);
	
//	게시글 목록 보기
	List<BoardDTO> boardList();
	
//	게시글 상세 조회
	BoardDTO getBoardInfo(String board_no);
	
//	게시글 수정
	int update(BoardDTO board);
	
//	게시글 삭제
	int delete(String board_no);
	
//	제목으로 검색
	List<BoardDTO> search(String data);
	
//	게시글 제목, 작성자, 본문, 작성일 검색
	List<BoardDTO> search(String tag, String data);
	
//	카테고리로 검색
	List<BoardDTO> findByCategory(String category);
	

}
