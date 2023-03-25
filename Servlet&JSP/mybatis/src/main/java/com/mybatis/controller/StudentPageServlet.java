package com.mybatis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.StudentService;
import com.mybatis.model.vo.Student;

/**
 * Servlet implementation class StudentPageServlet
 */
@WebServlet("/student/studentPage.do")
public class StudentPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cPage;
        int numperPage;
        
        try {
            cPage=Integer.parseInt(request.getParameter("cPage"));
	    }catch(NumberFormatException e) {
	        cPage=1;
	    }
        
        try {
            numperPage=Integer.parseInt(request.getParameter("numperPage"));
        }catch(NumberFormatException e) {
            numperPage=5;
        }
        
        List<Student> list = new StudentService().selectStudentPage(cPage,numperPage);
        
        // 총 개수..
        int totalData = new StudentService().selectStudentCount();
        System.out.println("totalData -> " + totalData);
        
        // 총개수를 최대 page로 나누기..
        int totalPage = (int)(Math.ceil((double)totalData/numperPage));
        System.out.println("totalPage -> " + totalPage);
        
        // set..
        int pageBarSize=5;
        

        int pageNo = ((cPage - 1) / pageBarSize) * pageBarSize + 1;
        System.out.println("pageNo -> " + pageNo);
        

        int pageEnd = pageNo + pageBarSize - 1;
        System.out.println("pageEnd -> " + pageEnd);
        
        String pageBar="";
        
        if(pageNo==1) {
            pageBar+="<span>[이전]</span>";
        }else {
            pageBar+="<a href='"+request.getRequestURI()
            +"?cPage="+(pageNo-1)+"&numperPage="+numperPage+"'>[이전]</a>";
        }
        
        while(!(pageNo > pageEnd || pageNo > totalPage)) {
	        if(pageNo==cPage) {
	           pageBar+="<span>"+pageNo+"</span>";
	        }else {
	           pageBar+="<a href='"+request.getRequestURI()
	           +"?cPage="+pageNo+"&numperPage="+numperPage+"'>"+pageNo+"</a>";
	        }
	        pageNo++;
        }
        
         if(pageNo>totalPage) {
            pageBar+="<span>[다음]</span>";
         }else {
            pageBar+="<a href='"+request.getRequestURI()
            +"?cPage="+pageNo+"&numperPage="+numperPage+"'>[다음]</a>";
         }
         
         request.setAttribute("pageBar", pageBar);      
 
         request.setAttribute("list", list);
         request.getRequestDispatcher("/views/studentContent.jsp")
         .forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
