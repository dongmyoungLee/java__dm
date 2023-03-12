package com.web.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.member.service.MemberService;
import com.web.member.vo.Member;

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
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		String saveId=request.getParameter("saveId");	
		//web계정의 Member테이블에 userId, password가 일치하는 회원이 있는지 조회
		System.out.println(saveId);
		
		if(saveId!=null) {
			//아이디저장이 체크되어있구나....
			//Cookie이용해서 처리하기.... 클라이언트의 저장소에 문자열을 저장하고 요청시 가져오는값
			Cookie c=new Cookie("saveId",userId);
			c.setMaxAge(60*60*24*7);
			response.addCookie(c);
		}else {
			//저장된 쿠키를 지워줌
			Cookie c=new Cookie("saveId","");
			c.setMaxAge(0);//
			response.addCookie(c);
		}
		
		Member m=new MemberService().selectMember(userId);
		System.out.println(m);
		//m이 null이면 로그인 실패!
		//m이 null이 아니면 로그인 성공
		if(m!=null&&m.getPassword().equals(password)) {
			//로그인 성공
			//로그인 성공에 대한 정보는 로그아웃할때까지 유지 
			HttpSession session=request.getSession();
			m.setPassword("");
			session.setAttribute("loginMember", m);
			
//			RequestDispatcher rd=request.getRequestDispatcher("");
//			rd.forward(request, response);
			response.sendRedirect(request.getContextPath());	
		}else {
			//로그인 실패
			request.setAttribute("msg", "로그인 실패");
			request.setAttribute("loc", "/");
			RequestDispatcher rd=request.getRequestDispatcher("/views/common/msg.jsp");
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
