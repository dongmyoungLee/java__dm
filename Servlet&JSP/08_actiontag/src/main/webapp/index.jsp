<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>action 태그 활용</title>
</head>
<body>
	<h2>액션태그 활용</h2>
	<p>jsp 페이지에서 java코드를 html 태그 방식으로 설정할수 있게해줌</p>
	<ul>
		<li>
			표준 액션태그 : jsp 에서 기본으로 제공하는 액션태그
		</li>
		<li>
			커스텀 액션태그(JSTL) : 별도의 라이브러리로 제공되는 태그 * 외부에서 jar 파일을 가져와서 넣어줘야함.
		</li>
	</ul>
	<p>액션태그는 태그명앞에 prefix를 붙인다.</p>
	<h2>표준액션태그</h2>
	<p>jsp:include  ->  다른 jsp 페이지를 불러와 출력해주는 태그
	   jsp:param    ->  jsp 페이지에 데이터를 전달할때 사용 * key value 형식으로 전달 태그 사용해보기
	</p>
	<h3><a href="<%= request.getContextPath()%>/views/includes.jsp">include</a></h3>
</body>
</html>