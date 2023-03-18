package com.el.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.el.vo.Member;

/**
 * Servlet implementation class ElDataTestServlet
 */
@WebServlet("/ElDataTestServlet")
public class ElDataTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElDataTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("request", "requestData");
		
		HttpSession session = request.getSession();
		session.setAttribute("session", "sessionData");
		
		ServletContext context = request.getServletContext();
		context.setAttribute("context", "contextData");
		
		//객체데이터 저장
		Member m = Member.builder()
					.userId("admin")
					.password("1234")
					.userName("관리자")
					.age(40)
					.weight(65.5)
					.build();
		request.setAttribute("loginMember", m);
		
		List<Member> list = List.of(
				Member.builder()
				.userId("admin")
				.password("1234")
				.userName("관리자")
				.age(40)
				.weight(65.5)
				.build(),
				Member.builder()
				.userId("user01")
				.password("1111")
				.userName("유저01")
				.age(11)
				.weight(65.5)
				.build(),
				Member.builder()
				.userId("admin")
				.password("1234")
				.userName("관리자")
				.age(40)
				.weight(65.5)
				.build()
				);
		
		request.setAttribute("members", list);
		
		request.setAttribute("session", "requestSessionData");
		
		request.getRequestDispatcher("/views/el/dataTest.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
