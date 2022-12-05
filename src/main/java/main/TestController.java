package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@RequestMapping("/test.do")
	public ModelAndView test() {
//		스프링에서 사용하는 뷰와 모델의 정보를 가지고 있는 객체
		ModelAndView mav = new ModelAndView();
//		ModelAndView mav = new ModelAndView("main/index");
		
		for (int i = 1; i <= 9; i++) {
			System.out.println("7 X " + i + " = " + 7 * i);
		}
//		공유데이터를 저장 [→ request.setAttribute("공유명", 공유할 객체)]
		mav.addObject("msg", "스프링에서 전달되는 데이터");
		
//		요청 재지정 할 뷰의 이름을 셋팅 → foward 가 디폴트
		mav.setViewName("main/result");
		return mav;
	}

}
