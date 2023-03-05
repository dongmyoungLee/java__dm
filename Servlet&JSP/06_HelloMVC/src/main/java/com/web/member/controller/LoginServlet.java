package com.web.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.service.MemberService;
import com.member.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		// web 계정의 Member 테이블에 userId, password 가 일치 하는 회원이 있는지 조회..
		Member m = new MemberService().selectMember(userId);

		
		if(m != null && m.getPassword().equals(password)) {
			// 로그인 성공에 대한 정보는 로그아웃 할 때 까지 유지가 되어야한다.. 따라서 세션에 저장하자..
			HttpSession session = request.getSession();
			
			// 딱히 password 까지 보낼 필요는 없는것같은데..
			m.setPassword("");
			
			session.setAttribute("loginMember", m);
			
			// forward 할 시.. 새로고침하면 계속 요청되니까 Redirect 쓰자..
			response.sendRedirect(request.getContextPath());
			
 		} else {
			// 로그인 실패
 			request.setAttribute("msg", "로그인 실패");
 			request.setAttribute("loc", "/");
 			RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg.jsp");
 			rd.forward(request, response);
 						
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
