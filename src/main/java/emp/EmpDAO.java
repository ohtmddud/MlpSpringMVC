package emp;

import java.util.List;

public interface EmpDAO {
//	회원 가입
	int insert(EmpDTO user);

//	Mybatis 회원 가입
	int SignUp(EmpDTO user);

//	회원 정보 수정
	int update(EmpDTO user);

//  회원 탈퇴
	int delete(String id);

//	로그인
	EmpDTO login(String id, String pass);

//	아이디로 회원 조회
	EmpDTO findById(String id);

//	전체 회원 조회
	List<EmpDTO> getMemberList();
	
//	Mybatis로 전체 회원 조회
	List<EmpDTO> AllUserList();
	
//	주소로 회원 조회
	List<EmpDTO> findBySearch(String search, String addr);
	
	
}
