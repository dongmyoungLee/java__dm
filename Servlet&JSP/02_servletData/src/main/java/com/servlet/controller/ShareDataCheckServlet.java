package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShareDataCheckServlet
 */
@WebServlet("/shareDataCheck.do")
public class ShareDataCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareDataCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setAttribute 로 저장된 데이터는 모두 Object 여서 강제형변환 필요
		String requestData = (String)request.getAttribute("request");
		HttpSession session = request.getSession();
		String sessionData = (String)session.getAttribute("session");
		ServletContext context = request.getServletContext();
		String contextData = (String)context.getAttribute("context");
		
		System.out.println(requestData);
		System.out.println(sessionData);
		System.out.println(contextData);
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String html = "<html>";
		html += "<body>";
		html += "<h1> request : " + requestData + "</h1>";
		html += "<h1> session : " + sessionData + "</h1>";
		html += "<h1> context : " + contextData + "</h1>";
		html += "<button onClick='location.assign(\"/02_servletData/shareDataCheck.do\")'>이동</button>";
		html += "<button onClick='location.assign(\"/02_servletData/deleteSession.do\")'>세션삭제</button>";
		html += "</body>";
		html += "</html>";
		
		out.print(html);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
