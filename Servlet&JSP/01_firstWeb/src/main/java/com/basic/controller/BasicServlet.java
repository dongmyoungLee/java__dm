package com.basic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿을 만들려면 규약을 준수해야함..
// 일반 클래스가 HttpServlet 클래스를 상속받으면 됨.. -> 서블릿이됨
public class BasicServlet extends HttpServlet {
	// HttpServlet 상속받은 클래스는(서블릿) HttpServlet 이 제공하는 두개의 메소드를 재정의힘.
	// doGet(), doPost() 메소드를 구현..
		
	
	// 생성된 서블릿이 실행이 되려면 주소 맵핑을 해줘야한다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("서블릿 실행 GET");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("서블릿 실행 POST");
	}
	
	
}
