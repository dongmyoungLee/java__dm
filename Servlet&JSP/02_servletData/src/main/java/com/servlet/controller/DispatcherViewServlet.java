package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherViewServlet
 */
@WebServlet("/dispatcherview.do")
public class DispatcherViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		double height = Double.parseDouble(request.getParameter("height"));
		String color = request.getParameter("color");
		String food = request.getParameter("lunch");
		String data = (String)request.getAttribute("info");
		
		// 2. 다중값 -> getParameterValues() -> String[]
		String[] animals = request.getParameterValues("animal");
		
		System.out.println(data);
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		System.out.println(color);
		System.out.println(food);
		System.out.println(Arrays.toString(animals));
		
		// response 객체를 이용해서 응답페이지 작성하기..
				// 1. 응답데이터에 대한 타입을 설정 -> MIME 타입으로 설정
				response.setContentType("text/html;charset=utf-8");
				
				// 2. 클라이언트의 Stream을 가져온다.
				// getWriter() : 문자열로 응답 -> html 코드를 응답할때 사용
				// getOutputStream() : 파일전송할때
				
				PrintWriter out = response.getWriter();
				
				// 3. 응답할 페이지를 작성하기.
				String html = "<html>";
				html += "<head>";
				html += "<title>당신의 취향분석</title>";
				html += "</head>";
				html += "<body>";
				html += "<h1>" + data + "</h1>";
				html += "<h1>" + name + "님의 취향</h1>";
				html += "<h2> 당신의 이름은 " + name + "이고 나이는 " + age + "살 입니다.</h2>";
				html += "<h3> 키 " + height + "이고 좋아하는 색은 <span style='color : " + color + "'>" + color + "</span>입니다.";
				html += "<ul>";
				
				for(String a : animals) {
					html += "<li>";
					String src = "";
					
					switch(a) {
						case "강아지" :
							src = "https://image.kmib.co.kr/online_image/2022/1023/2022102113444970898_1666327489_0017592082.jpg";
						break;
						
						case "고양이" :
							src = "https://mblogthumb-phinf.pstatic.net/20160512_297/gatoblancokr_1463028030970omGoS_JPEG/Siamese-cat-on-couch.jpg?type=w2";
						break;
					}
					
					html += "<img src="+ src +" style='width: 100px; height: 100px;'>";
					html += "</li>";
				}
				html += "</ul>";
				html += "<h3>오늘의 점심은 " + food + " 먹기 </h3>";
				html += "</body>";
				html += "</html>";
				
				// 문자열로 작성된 html 코드를 전송
				out.write(html);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
