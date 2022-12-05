package emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReadController {
	EmpDAO dao;

	@Autowired
	public ReadController(EmpDAO dao) {
		super();
		this.dao = dao;
	}

	@RequestMapping("/emp/read.do")
	public ModelAndView ReadEmp(String id) {
		ModelAndView mav = new ModelAndView("emp/emp_read");
		EmpDTO emp = dao.findById(id);
		System.out.println(emp);
		mav.addObject("user", emp);
		return mav;
	}

}
