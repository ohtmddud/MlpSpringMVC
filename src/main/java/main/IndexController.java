package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// Tiles 기반으로 뷰를 만들어 낼 수 있도록 작업
@Controller
public class IndexController {

	@RequestMapping("/index.do")
	public String index() {
//		System.out.println("index 컨트롤러 실행");
		return "index";
		// View 의 정보 - Tiles 설정 파일에 등록한 <definition> 의 name 속성에 정의한 이름
	}

	@RequestMapping("/menu/servlet")
	public String menuServlet() {
		return "menu/servlet";
	}
	


}
