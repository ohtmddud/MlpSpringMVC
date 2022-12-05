
package emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {
	EmpDAO dao;
	
	@Autowired
	public ListController(EmpDAO dao) {
		super();
		this.dao = dao;
	}

	@RequestMapping("/emp/list.do")
	public ModelAndView showUserList() {
		ModelAndView mav = new ModelAndView("emp/emp_list");
		List<EmpDTO> empList = dao.getMemberList();

		mav.addObject("empList", empList);
		return mav;
	}
	
	@RequestMapping("/emp/mybatis/list.do")
	public ModelAndView MybatisShowUserList() {
		ModelAndView mav = new ModelAndView("emp/list");
		List<EmpDTO> empList = dao.getMemberList();
		
		mav.addObject("empList", empList);
		return mav;
	}
	
	

}
