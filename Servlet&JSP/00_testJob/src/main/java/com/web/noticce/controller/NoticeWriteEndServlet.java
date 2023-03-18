package com.web.noticce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.web.noticce.service.NoticeService;
import com.web.noticce.vo.Notice;

/**
 * Servlet implementation class NoticeWriteEndServlet
 */
@WebServlet("/notice/writeend.do")
public class NoticeWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공지사항을 등록
		//파일을 저장해야함.
		//1. 요청이 multipart/form-data방식으로 왔는지 확인하고 
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "잘못된 요청방식입니다 :( ");
			request.setAttribute("loc", "/notice/noticeList.do");
			request.getRequestDispatcher("/views/common/msg.jsp")
			.forward(request, response);
		}else {
			//cos.jar에서 제공하는 클래스를 이용해서 처리함.
			//MultipartRequest클래스를 제공함.
			// multipart/form-data방식의 요청을 가지고 클라이언트 보낸 파일은 파일대로,
			// 데이터는 데이터로 분할하여 처리해주는 기능.
			// 보낸파일은 지정한 폴더에 바로 저장해줌.
			
			//MultipartRequest이용하기
			// 매개변수있는 생성자를 이용해서 생성하고
			// request가 제공하는 메소드와 유사한메소드를 이용해서 정보를 처리하면됨.
			//5개의 매개변수를 전달해야함.
			//1 : HttpServletRequest
			//2 : 클라이언트가 보낸 파일 저장위치(절대경로)
			//3 : 파일의 최대크기설정
			//4 : 인코딩방식 UTF-8
			//5 : 저장할파일에 대한 네이밍규칙 *적용할 기본 클래스를 제공
			//저장경로가져오기
			String path=request.getServletContext().getRealPath("/upload/notice");
			//저장크기
			//byte -> MB -> GB -> TB .......
			int maxSize=1024*1024*10;//10MB
			//인코딩설정
			String encode="UTF-8";
			//renamePolicy 규칙
			DefaultFileRenamePolicy dfc=new DefaultFileRenamePolicy();
			
			MultipartRequest mr=new MultipartRequest(request,path,maxSize,encode,dfc);
			
			//업로드된 파일에 대한 정보를 가져올수있음
			String fileName=mr.getFilesystemName("upfile");
			//mr.getOriginalFileName("upload");//upload된 파일명을 가져올 수 있음
			//매개변수 : type file의 name속성명 -> rename 파일명을 가져오기
			
			//파일이외의 데이터는 getParameter()메소드를 이용해서 가져올 수 있음
			String noticeTitle=mr.getParameter("noticeTitle");
			String noticeWriter=mr.getParameter("noticeWriter");
			String noticeContent=mr.getParameter("noticeContent");
			Notice n=Notice.builder()
					.noticeTitle(noticeTitle)
					.noticeWriter(noticeWriter)
					.noticeContent(noticeContent)
					.filePath(fileName)
					.build();
			
			System.out.println(n);
			int result=new NoticeService().insertNotice(n);
			String msg,loc;
			if(result>0) {
				msg="공지사항 등록 성공";
				loc="/notice/noticeList.do";
			}else {
				msg="공지사항 등록 실패 다시 시도하세요 :(";
				loc="/notice/wirte.do";
			}
			request.setAttribute("msg",msg);
			request.setAttribute("loc",loc);
			request.getRequestDispatcher("/views/common/msg.jsp")
			.forward(request, response);
					
			
			
			
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
