package com.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDispatcherTestServlet
 */
@WebServlet("/requestDispatcher.do")
public class RequestDispatcherTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDispatcherTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 요청을 받는 서블릿
		// DB에서 데이터를 가져오거나 아니면 추가 데이터를 생성하는 역할.
		System.out.println("requestDisplatcherTest 서블릿 실행!");
		
		// 비즈니스 로직을 처리한 데이터를 추가할 수 있다.
		request.setAttribute("info", "추가된 데이터");
		
		// 화면을 출력해주는 역할을 하는 서블릿 호출
		RequestDispatcher rd = request.getRequestDispatcher("/dispatcherview.do");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
