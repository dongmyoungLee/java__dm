package com.web.noticce.service;

import java.sql.Connection;
import java.util.List;

import com.web.noticce.dao.NoticeDao;
import com.web.noticce.vo.Notice;
import static com.web.common.JDBCTemplate.*;

public class NoticeService {
	private NoticeDao dao=new NoticeDao();
	
	public List<Notice> noticeList(){
		Connection conn=getConnection();
		List<Notice> list=dao.noticeList(conn);
		close(conn);
		return list;
	}
	
	public int insertNotice(Notice notice) {
		Connection conn=getConnection();
		int result=dao.insertNotice(conn,notice);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public Notice selectNoticeByNo(int noticeNo) {
		Connection conn=getConnection();
		Notice n=dao.selectNoticeByNo(conn,noticeNo);
		close(conn);
		return n;
	}
}
