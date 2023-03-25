<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.member.vo.Member" %>    
<%
	Member loginMember=(Member)session.getAttribute("loginMember");
	Cookie[] cookies=request.getCookies();
	String saveId=null;
	if(cookies!=null){
		for(Cookie c : cookies){
			if(c.getName().equals("saveId")){
				saveId=c.getValue();
				break;
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelloMVC프로젝트</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css"/>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div id="container">
		<header>
			<h1>HelloMVC</h1>
			<div class="login-container">
			<%if(loginMember==null){ %> 
				<form id="lofinFrm" action="<%=request.getContextPath() %>/login.do" method="post">
					<table>
						<tr>
							<td>	
								<input type="text" name="userId" id="userId"
								placeholder="아이디" 
								value="<%=saveId!=null?saveId:""%>">
							</td>
						</tr>
						<tr>
							<td>
								<input type="password" name="password" id="password"
								placeholder="패스워드">
							</td>
							<td>
								<input type="submit" value="로그인">
							</td>
						</tr>
						<tr>
							<td>
								<input type="checkbox" name="saveId" id="saveId"
								<%=saveId!=null?"checked":"" %>>
								<label for="saveId">아이디저장</label>
								<input type="button" value="회원가입"
								onclick="location.assign('<%=request.getContextPath()%>/member/enrollMember.do')">
							</td>
						</tr>
					</table>
				</form>
				<%}else{ %>
					<table id="logged-in">
						<tr>
							<td colspan="2">
								<%=loginMember.getUserName() %>님, 어서오세요!
							</td>
						</tr>
						<tr>
							<td>
								<input type="button" value="내정보보기" 
								onclick="location.assign('<%=request.getContextPath() %>/memberview.do?userId=<%=loginMember.getUserId()%>');">
							</td>
							<td>
								<input type="button" value="로그아웃"
								onclick="location.replace('<%=request.getContextPath()%>/logout.do');">
							</td>
						</tr>
					</table>
				<%} %>
				
			</div>
			<nav>
				<ul class="main-nav">
					<li class="home"><a href="">Home</a></li>
					<li id="notice">
						<a href="<%=request.getContextPath()%>/notice/noticeList.do">공지사항</a>
					</li>
					<li id="board"><a href="">게시판</a></li>
					<li id="gallary"><a href="">갤러리</a></li>
					<%if(loginMember!=null&&loginMember.getUserId().equals("admin")){ %>
						<li id="memberManage">
							<a href="<%=request.getContextPath()%>/admin/memberList.do">
							회원관리
							</a>
						</li>
					<%} %>
				</ul>
			</nav>
		</header>

