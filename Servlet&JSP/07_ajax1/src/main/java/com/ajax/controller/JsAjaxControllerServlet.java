package com.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JsAjaxControllerServlet
 */
@WebServlet("/ajax/jsAjax.do")
public class JsAjaxControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsAjaxControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ajax 요청 응답.
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		/*Thread t = new Thread(() -> {
			try {
				Thread.sleep(3000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t.run();
		*/
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		PrintWriter out = response.getWriter();
		out.write("<h1>내가 ajax요청에 대해 응답한 내용</h1>");
		out.write("<h4>전송한 데이터 : " + name + " : " + age +  " </h4>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
