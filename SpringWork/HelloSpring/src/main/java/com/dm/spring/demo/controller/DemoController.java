package com.dm.spring.demo.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dm.spring.demo.model.vo.Demo;

@Controller
public class DemoController {
	
	// 클라이언트가 요청한 서비스를 실행해주는 기능
	// 클라이언트가 요청한 서비스 주소에 맞는 메소드를 mapping
	// 메소드 선언부에 mapping 주소에 대해 설정으 어노테이션으로 함.
	// @RequestMapping, @GetMapping, @PostMapping
	// @RequesetMapping("연결주소")
	// @RequesetMapping(value="연결주소" [추가옵션설정])
	
	@RequestMapping("/demo/demo.do")
	public String demoPage() {
		// 맵핑 메소드는 servlet 에서 doGet, doPost 와 동일한 기능을 함..
		// 맵핑 메소드의 메소드명은 개발자가 정함(서비스를 알아볼 수 있게 설정하자) 
		// demo 페이지를 출력해주는 서비스
		// spring 에서 view를 연결할때는 ViewResolverBean을 이용한다..
		// InternalResourceViewResolver 를 등록해서 활용한다. (jsp 연결시..)
		// InternalResourceViewResolver 맵핑메소드가 반환하는 값을 가지고
		// Resouce 내부에 있는 jsp화면을 찾아서 반환을 해줌.
		// RequestDispatcher.forward() 방식으로 응답함
		
		// String이 반환값일때 그 string 값은 응답할 페이지 이름이 된다.
		// InternalResourceViewResolver 에 설정된 prefix, suffix 값을 붙여서 경로와 페이지 확장자를 설정한다.
		// /WEB-INF/views/demo/demo.jsp
	
		return "demo/demo";
	
	}
	
	// spring 에서 클라이언트가 전송한 데이터 받기
	// 맵핑 메소드의 반환형과 매개변수
	
	// 1. 반환형
	// - String : ViewResolver 에 의해서 view 화면(jsp)를 반환할때 사용 
	// - ModelAndView : 화면에서 이용할 데이터와 화면을 모두 저장하는 객체
	// - void : HttpServletResponse 객체를 이용해서 응답메세지를 작성(download, upload, json 데이터 전송)
	// - 클래스타입(Vo 객체, List, Map) : 서비스에서 생성된 객체 자체를 반환할때 -> json 으로 변환
	// @ResponseBody 선언과 converter(jackson)를 등록
	
	// 2. 매개변수 선언 -> springcontainer 가 알아서 전달해줌.
	// - HttpServletRequest : 서블릿에서 사용한 그 객체 -> request
	// - HttpServletResponse : 서블릿에서 사용한 그 객체 -> response
	// - HttpSession : HttpServletRequest객체 없어도 선어만 하면됨
	// - java.util.Locale : 서버의 로케일 정보를 저장한 객체를 전달해줌
	// - InputStream/Reader : 파일을 IO할때 사용하는 Stream객체
	// - OutputStream/Writer : 파일을 IO할때 사용하는 Stream객체
	// - 기본자료형 선언 : 클라이언트가 보낸 name 명칭이 선언한 매개변수의 이름과 동일할 경우 대입 이름이 다를 경우 @RequestParam 어노테이션으로 연결해줄수있음.
	// - 클래스 타입(vo,dto) : command 라고 하고 클라이언트가 보낸 데이터와 command 객체의 멤버변수와 같으면 객체를 생성해서 대입해줌
	// - java.util.Map : 클라이언트가 보낸 데이터를 map형식으로 변경해서 대입해줌
	
	
	// - Model : jsp 에서 사용할 데이터를 저장하는 객체 * request.setAttribute 한 것과 동일함.
	// - ModelAndView : model 객체와 반환할 view를 동시에 설정하는 객체
	
	// - 기본 자료형에 @CookieValue, @RequestHeader 어노테이션을 이용하면 cookie, Header 값을 간편하게 받아올 수 있음
	
	// 선언부에, 매개변수 선언부에.. -> converter 가 설정되어 있어야 함..
	// @ResponseBody : 반환하는 클래스를 json형태로 변환해서 반환
	// @RequestBody : 클라이언트가 보낸 json형태의 데이터를 vo 객체로 반환해서 저장
	
	
	// 서블릿 방식으로도 필요하면 이용하기
	@RequestMapping("/demo/demo1.do")
	public String demo1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("devName");
		int age = Integer.parseInt(request.getParameter("devAge"));
		String gender = request.getParameter("devGender");
		String email = request.getParameter("devEmail");
		String[] devlang = request.getParameterValues("devLang");
		
		Demo d = Demo.builder()
				.devName(name)
				.devAge(age)
				.devEmail(email)
				.devGender(gender)
				.devLang(devlang)
				.build();
		
		request.setAttribute("demo", d);
		
		return "demo/demoInfo";
	}
	
	// 클라이언트가 보낸데이터 기본자료형으로 받기 -> 클라이언트가 보낸 name 값, 변수명을 동일하게 설정
	// 매개변수로 선언한 데이터가 모두 전달되어야 함.
	@RequestMapping("/demo/demo2.do")
	public String demo2(String devName, int devAge, String devEmail, String devGender, String[] devLang, Model m) {
		
		Demo d = Demo.builder().devName(devName).devAge(devAge).devEmail(devEmail).devGender(devGender).devLang(devLang).build();
		
		// Model 객체를 이용해서 화면에 데이터를 저장함..
		// 저장방식은 request.setAttribute() 와 동일
		// key : value 형식으로 저장
		// Model.addAttribute("key", Object);

		m.addAttribute("demo", d);
		
		return "demo/demoInfo";
	}
	
	// @ReqeustParam 어노테이션을 이용해서 매개변수값에 대한 옵션 설정하기
	@RequestMapping("/demo/demo3.do")
	public String demo3(
			@RequestParam(value="devName") String name,
			@RequestParam(value="devAge", defaultValue="10") int age,
			@RequestParam(value="devEmail") String email,
			@RequestParam(value="devGender") String gender,
			@RequestParam(value="devLang", required=false) String[] lang,
			Model m) {
		
		m.addAttribute("demo", Demo.builder().devName(name).devAge(age).devEmail(email).devGender(gender).devLang(lang).build());
		
		
		return "demo/demoInfo";
	}
	
	//Command 객체를 이용해서 파라미터 직접받기
	//vo객체에 필드로 다른 클래스가 있는 경우 주의해야 한다.
	//날짜는 java.sql.Date를 이용하자..
	@RequestMapping("/demo/demo4.do")
	public String demo4(Demo demo, Model m) {
		System.out.println(demo);
		
		m.addAttribute("demo", demo);
		
		return "demo/demoInfo";
	}
	
	// Map 방식
	@RequestMapping("/demo/demo5.do")
	public String mapMappingTest(@RequestParam Map param, String[] devLang, Model m) {		
		param.put("devLang", devLang);
		m.addAttribute("demo", param);
		System.out.println(param);
		return "demo/demoInfo";
	}
	
	
	
}








