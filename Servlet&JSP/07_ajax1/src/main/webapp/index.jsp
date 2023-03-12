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
		<input id="paramData" type="text">
		<button onClick="postSendAjax();">post 요청</button>
		<div id="target"></div>
		<br><br><br>
	</div>
	<script>
		const basicAjaxTest = () => {
			const xhr = new XMLHttpRequest();
			
			xhr.onreadystatechange = () => {
				// 상태값 분기
				// readyState : 0 ~ 4(완료)
				if(xhr.readyState == 4) {
					// 응답처리에 대한 상태코드 확인.
					
					if (xhr.status == 200) {
						alert('성공');
						
						// XMLHttpRequest.responseText 속성 -> 서버에서 응답한 데이터가 저장됨
						console.log(xhr.responseText);
						document.querySelector("#target").innerHTML = xhr.responseText;
						
					} else if(xhr.status == 404) {
						alert('요청한 서비스는 없음');
					}
					
				} else {
					document.querySelector("#target").innerHTML = "<h2>로딩중...</h2>";
				}
				
				
			}
			const paramData = document.querySelector("#paramData").value;
			// 요청 내용에 대한 설정
			xhr.open('get', "<%=request.getContextPath()%>/ajax/jsAjax.do?name=" + paramData);
			
			// 3. 요청 보내기
			xhr.send();
		}
		
		const postSendAjax = () => {
			
			const xhr = new XMLHttpRequest();
			xhr.onreadystatechange = () => {
				if(xhr.readyState == 4) {
					if(xhr.status == 200) {
						document.getElementById("target").innerHTML = xhr.responseText;
					}
				}
			}
			xhr.open("post", "<%=request.getContextPath()%>/ajax/jsAjax.do");
			// post 방식으로 요청할때 추가설정 필요
			// header 의 contentType 을 설정.
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			
			// 데이터 전송시에는 send에 key=value 형태의 문자열을 전송
			const paramData = document.querySelector("#paramData").value;
			xhr.send("name=" + paramData + "&age=19");
			
		}
	</script>
</body>
</html>














