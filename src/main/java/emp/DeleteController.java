package emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteController {
	EmpDAO dao;

	@Autowired
	public DeleteController(EmpDAO dao) {
		super();
		this.dao = dao;
	}

	@RequestMapping("/emp/delete.do")
	public ModelAndView ReadEmp(String id) {
		ModelAndView mav = new ModelAndView("redirect:/emp/list.do");
		System.out.println(id);
		dao.delete(id);
		
		return mav;
	}

}
