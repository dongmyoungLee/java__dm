<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax</title>
</head>
<body>
	<h2>ajax 활용</h2>
	<p>js를 이용한 비동기 요청</p>
	
	<ul>
		<li>XMLHttpRequest - JS</li>
		<li>Jqeury</li>
	</ul>
	
	<h3>XMLHttpRequest 클래스 이용하기</h3>
	<p>
		1. XMLHttpRequest 클래스 생성 <br>
		2. 생성한 객체에 필요한 설정
		    - 서버가 응답한 내용 처리할 함수 등록
		    - XMLRequest.onreadystatechange 속성에 함수 대입
		    - 요청방식, 요청주소에 대한 설정
			- XMLHttpRequest.open('요청방식', '주소);
		3. 요청을 보내는 함수 호출
			- XMLHttpRequest.send() 함수
	</p>
	<div>
		<h2>서버에 요청 보내기</h2>
		<button onClick="basicAjaxTest();">send</button>		
	</div>
	<script>
		const basicAjaxTest = () => {
			const xhr = new XMLHttpRequest();
			
			xhr.onreadystateChange = () => {
				// 상태값 분기
				// readyState : 0 ~ 4(완료)
				if(xhr.readyState == 4) {
					// 응답처리에 대한 상태코드 확인.
					
				}
			}
		}
	</script>
</body>
</html>














