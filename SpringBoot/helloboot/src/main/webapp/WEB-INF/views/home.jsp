<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boot !!!</title>
</head>
<body>
	<h2>boot!!</h2>
	<h3><a href="${pageContext.request.contextPath}/member/memberAll.do">전체회원 조회</a></h3>
	
	<h2>파일 업로드 처리하기</h2>
	<form action="${pageContext.request.contextPath}/fileupload" method="post" enctype="multipart/form-data">
		<input type="file" name="upfile">
		<input type="submit" value="파일 전송">
	</form>
	
	<h2>
		<a href="${pageContext.request.contextPath}/jpa/member">전체 회원 가져오기 JPA</a>
	</h2>
	
	<h2>
		<select id="selectId">
		
		</select>
		<button onclick="searchId();">검색하기</button>
	</h2>
	
	<script>
		const searchId = () => {
			const id = document.getElementById("selectId").value;
			const url = "${pageContext.request.contextPath}/jpa/member/";
			location.assign(url + id);
		}
		
		fetch("${pageContext.request.contextPath}/jpa/member/")
		.then(response => response.json())
		.then(data => {
			const $selectContainer = document.getElementById("selectId");
			
			console.log(data);
			
			data.forEach(e => {
				const $option = document.createElement("option");
				$option.value = e.userId;
				$option.innerText = e.userId;
				
				$selectContainer.appendChild($option);
			})
		});
	</script>
	
	<h2>회원 저장하기</h2>
	<div id="enrollMember">
		<form action="${pageContext.request.contextPath}/jpa/member/" method="post">
			<input type="text" name="userId" placeholder="ID"><br>
			<input type="password" name="password" placeholder="password"><br>
			<input type="text" name="userName" placeholder="이름"><br>
			<lable>
				<input type="radio" name="gender" value="M" placeholder="성별">남
			</lable>
			<lable>
				<input type="radio" name="gender" value="M" placeholder="성별">여<br>
			</lable>
			
			<input type="number" size="3" name="age" placeholder="나이"><br>
			<input type="text" name="email" placeholder="이메일"><br>
			<input type="text" name="address" placeholder="주소"><br>
			<input type="text" name="phone" placeholder="전화번호"><br>
			
			<label><input type="checkbox" name="hobby" value="운동">운동</label>
			<label><input type="checkbox" name="hobby" value="등산">등산</label>
			<label><input type="checkbox" name="hobby" value="독서">독서</label>
			<br>
			<input type="submit" value="회원가입">
		</form>
	</div>
	
	<h2>이름으로 조회하기</h2>
	<input id="searchName" type="text" name="name">
	<button onclick="searchName();">검색하기</button>
	<script>
		const searchName = () => {
			const name = document.querySelector("#searchName").value;
			location.assign("${pageContext.request.contextPath}/jpa/member/name/" + name)
		}
	</script>
	
	<h2>채팅서버연결</h2>
	<button onclick="openChatting();">채팅하기</button>
	<script>
		let socket;
		const openChatting = () => {
			
			socket = new WebSocket("ws://localhost:9091/chatting");

			socket.onopen = (data) => {
				console.log(data);
			}
		}
	</script>
	
	<h2><a href="${pageContext.request.contextPath}/jpa/board">게시글 전체요청</a></h2>
</body>
</html>















