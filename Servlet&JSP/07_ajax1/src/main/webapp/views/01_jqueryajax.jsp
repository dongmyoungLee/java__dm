<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery 방식</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
</head>
<body>
	<ul>
		<li>$.ajax() 함수 : 요청에 대한 상세 설정 할때 -> 헤더, 데이터 등에 대한 설정</li>
		<li>$.get() 함수 : 기본 get 방식</li>
		<li>$.post() 함수 : 기본 post 방식</li>
	</ul>	
	
	<h2>$.ajax 이용</h2>
	
	<p>
		$.ajax() 함수의 매개변수는 요청에대한 설정값을 객체방식으로 보낸다.
		객체의 key 값이 모두 정해져 있음
		
		1. url : 요청할 주소 : String 필수
		2. type : get & post -> 생략시 default get
		3. data : 서버에 전송할 데이터(js obj)
		4. dataType : 응답받는 데이터에 대한 형식(text, json, xml .. 설정) 설정안하면 자동설정
		5. success : callback 함수 정삭적으로 통신을 완료했을때 실행될 로직 필수설정
		6. error : callback 함수 404, 500 등의 에러가 발생했을때 실행될 로직 생략가능.
		7.
		
	</p>
</body>
</html>