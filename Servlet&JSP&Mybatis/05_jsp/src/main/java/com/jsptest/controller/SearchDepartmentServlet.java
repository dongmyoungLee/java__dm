package com.jsptest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsptest.service.DepartmentService;
import com.jsptest.vo.Department;

/**
 * Servlet implementation class SearchDepartmentServlet
 */
@WebServlet("/searchdepartment.do")
public class SearchDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 보낸 검색어를 기준으로 department 를 조회하기..
		
		// post방식을 위해.. encoding 먼저 해주자.. 
		request.setCharacterEncoding("utf-8");
		
		// 클라이언트에서 보낸 keyword
		String keyword = request.getParameter("keyword");
		
		// DB Connecting 후 값 받아오자..
		List<Department> list = new DepartmentService().searchDepartment(keyword);
		
		// 로직 태우고 난 후 값 저장해주자..
		request.setAttribute("departments", list);
		
		// jsp 로 출력해주자..
		RequestDispatcher rd = request.getRequestDispatcher("/views/infoDepartment.jsp");
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
