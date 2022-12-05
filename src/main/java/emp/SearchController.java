package emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	EmpDAO dao;

	@Autowired
	public SearchController(EmpDAO dao) {
		super();
		this.dao = dao;
	}
	@RequestMapping(value = "/emp/search.do", method =RequestMethod.GET)
	public String showSearchView() {
		return "emp/search";
	}

	@RequestMapping(value = "/emp/search.do", method =RequestMethod.POST)
	public ModelAndView ReadEmp(String search, String addr) {
		ModelAndView mav = new ModelAndView("emp/emp_list");

		System.out.println(search);
		System.out.println(addr);
		List<EmpDTO> empList = dao.findBySearch(search, addr);

		System.out.println(empList);
		mav.addObject("empList", empList);

		return mav;
	}

}
