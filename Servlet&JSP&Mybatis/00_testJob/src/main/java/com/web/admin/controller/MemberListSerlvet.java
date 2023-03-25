package com.web.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.admin.service.AdminService;
import com.web.member.service.MemberService;
import com.web.member.vo.Member;

/**
 * Servlet implementation class MemberListSerlvet
 */
@WebServlet("/admin/memberList.do")
public class MemberListSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			//DB Member테이블에 저장된 모든 회원불러오는 기능
			//현재 페이지와 일치하는 데이터를 가져와 출력해주는 기능->페이징처리
			//내가 볼 페이지번호
			int cPage;
			
			try{
				cPage=Integer.parseInt(request.getParameter("cPage"));
			}catch(NumberFormatException e) {
				cPage=1;
			}
			
			int numPerpage=5;//페이지당 출력할 데이터 수
				
			
			List<Member> members=new AdminService().selectMemberList(cPage,numPerpage);
			
			//System.out.println(members);
			
			request.setAttribute("members", members);
			
			//pageBar생성하기
			//1. totalPage : 전체데이터/페이지당데이터수(numperPage)
			int totalData=new MemberService().selectMemberCount();
			
			int totalPage=(int)Math.ceil((double)totalData/numPerpage);
			
			//pageBar html코드로 저장할 변수
			String pageBar="";
			//pageBar에 출력될 번호 갯수
			int pageBarSize=5;
			//pageBar에 출력될 번호를 나타내는 변수
			int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
			int pageEnd=pageNo+pageBarSize-1;
			
			if(pageNo==1) {
				pageBar+="<span>[이전]</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()
				+"/admin/memberList.do?cPage="+(pageNo-1)+"'>[이전]</a>";
			}
			
			//출력될 번호설정
			while(!(pageNo>pageEnd||pageNo>totalPage)) {
				if(cPage==pageNo) {
					pageBar+="<span>"+pageNo+"</span>";
				}else {
					pageBar+="<a href='"+request.getContextPath()
					+"/admin/memberList.do?cPage="+pageNo+"'>"+pageNo+"</a>";
				}
				pageNo++;
			}
			
			if(pageNo>totalPage) {
				pageBar+="<span>[다음]</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()
				+"/admin/memberList.do?cPage="+pageNo+"'>[다음]</a>";
			}
			
			request.setAttribute("pageBar",pageBar);
			
			
			
			
			
			
			
			
			request.getRequestDispatcher("/views/admin/memberList.jsp")
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
