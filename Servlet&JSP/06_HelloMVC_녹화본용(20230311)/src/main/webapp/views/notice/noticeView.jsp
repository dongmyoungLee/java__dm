<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.noticce.vo.Notice" %>    
<%
	Notice n=(Notice)request.getAttribute("notice");
%>    
<%@ include file="/views/common/header.jsp"%>
<div id="notice-container">
		<h2>공지사항 상세보기</h2>
        <table id="tbl-notice">
        <tr>
            <th>제 목</th>
            <td><%=n.getNoticeTitle() %></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><%=n.getNoticeWriter() %></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td>
              <%if(n.getFilePath()==null){ %>
              	첨부파일없음
              <%}else{ %>
              	
              	<img src="<%=request.getContextPath()%>/images/file.png" width="25"
              	onclick="fn_fileDown('<%=n.getFilePath()%>');"/>
              	<span><%=n.getFilePath()%></span>
              <%} %>
            </td>
        </tr>
        <tr>
            <th>내 용</th>
            <td><%=n.getNoticeContent() %></td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="button" value="수정하기" onclick="">
                <input type="button" value="삭제하기" onclick="">
            </th>
        </tr>
    </table>
    </div>
	<script>
		const fn_fileDown=fileName=>{
			location.assign('<%=request.getContextPath()%>/notice/fileDown.do?filename='+fileName)
		}
	
	</script>
<style>
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
</style>

<%@ include file="/views/common/footer.jsp"%>