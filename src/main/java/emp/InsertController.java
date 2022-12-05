package emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InsertController {
	EmpDAO dao;

	@Autowired
	public InsertController(EmpDAO dao) {
		super();
		this.dao = dao;
	}

	// 가입 페이지를 response
	@RequestMapping(value = "/emp/insert.do", method = RequestMethod.GET)
	public String showLoginView() {
//		return "emp/register";
		return "emp/add";
	}

//	DB에 정보 insert 하기
	@RequestMapping(value = "/emp/insert.do", method = RequestMethod.POST)
//	public String insert(@RequestParam("deptno") String deptno, String name) {
	public String insert(EmpDTO user) {
		dao.insert(user);
		return "redirect:/emp/list.do";

	}
	
	@RequestMapping(value = "/emp/mybatis/insert", method = RequestMethod.GET)
	public String SignUpView() {
		return "emp/register";
	}

	@RequestMapping(value = "/emp/mybatis/insert", method = RequestMethod.POST)
	public String SignUp(EmpDTO user) {
		dao.insert(user);
		return "redirect:/emp/list.do";
		
	}

}
