package com.dm.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dm.spring.model.vo.Food;
import com.dm.spring.model.vo.Person;
import com.dm.spring.model.vo.Phone;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	// spring bean 으로 등록된 bean 사용하기
	// spring 에게 자동으로 불러와 달라고 설정
	// @Autowired 어노테이션을 이용함.. -> 의존성주입 (DI)
	// 지역변수에서는 활용이 불가능함..!!
	// 멤버변수로 선언한 것을 이용할 때 사용할 수 있음..
	
	// 등록된 spring bean 중에서 type이 일치하는 bean을 알아서 대입을 해줌.
	// 필드명과 등록된 bean 의 id값이 일치하면 지동으로 맵핑을 해서 가져옴
	// @Autowired 했을때 동일한 타입의 bean 다수일때는 어노테이션을 이용해서 특정 할 수 있음.
	
	
	@Autowired 
	@Qualifier(value="p2")
	private Person person;
	
	
	// 생성자를 이용해서 필드에 주입할 수 있음
	/*
	public HomeController(@Qualifier("p3") Person person) {
		this.person = person;
	}
	*/
	
	/*
	@Autowired
	public void setPerson(@Qualifier("p2") Person person) {
		this.person = person;
	}
	*/
	
	
	@Autowired
	@Qualifier("food")
	private Food f;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// 추가 기능설정하기
	@RequestMapping("/test")
	public String test() {
		System.out.println("실행됨");
		// p 에 데이터가 있는지 확인하기
		System.out.println(f);
		return "index";
	}
	
	
	 
	
}
