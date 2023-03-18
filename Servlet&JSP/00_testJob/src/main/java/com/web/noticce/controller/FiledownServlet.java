package com.web.noticce.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FiledownServlet
 */
@WebServlet("/notice/fileDown.do")
public class FiledownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiledownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//파일다운로드 서비스 구현하기
		//1. 클라이언트가 다운로드요청한 파일명 가져오기
		String fileName=request.getParameter("filename");
		
		//2. 업로드폴더에서 클라이언트가 보낸 파일을 가져오기
		String path=request.getServletContext().getRealPath("/upload/notice/");
		//InputStream을 이용해서 파일을 가져옴.
		FileInputStream fis=new FileInputStream(path+fileName);
		BufferedInputStream bis=new BufferedInputStream(fis);
		
		//3. 파일명이 한글일때 깨지는것을 방지하기 -> 인코딩처리
		String fileRename="";
		String header=request.getHeader("user-agent");
		boolean isMS=header.indexOf("MSIE")!=-1||header.indexOf("Trident")!=-1;
		if(isMS) {
			//익스플로러
			fileRename=URLEncoder.encode(fileName,"UTF-8")
					.replaceAll("\\+", "%20");
		}else {
			//그외 브라우저
			fileRename=new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		}
		
		//4. 응답해더 설정하기
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename="+fileRename);
		
		
		//5. 클라이언트 스트림을 가져오기
		ServletOutputStream sos=response.getOutputStream();
		BufferedOutputStream bos=new BufferedOutputStream(sos);
		
		int read=-1;
		while((read=bis.read())!=-1) {
			bos.write(read);
		}
		
	
		bis.close();
		bos.close();
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
