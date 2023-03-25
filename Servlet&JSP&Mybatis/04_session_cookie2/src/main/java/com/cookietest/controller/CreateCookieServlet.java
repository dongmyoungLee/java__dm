package com.cookietest.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateCookieServlet
 */
@WebServlet("/createcookie.do")
public class CreateCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 쿠키 생성하고 클라이언트에 저장시키기
		Cookie c = new Cookie("userId", "admin");
		Cookie c2 = new Cookie("readPro", "|1|2|3");
		
		// 상세정보 설정
		c.setMaxAge(60 * 60 * 24);
		
		
		response.addCookie(c);
		response.addCookie(c2);
		
		// context-param 으로 등록된 데이터 가져오기
		ServletContext context = request.getServletContext();
		String data = context.getInitParameter("admin");
		System.out.println(data);
		
		response.sendRedirect(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
