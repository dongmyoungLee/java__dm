<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>megaChat</title>
		<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.3.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/chatting.js"></script>
	</head>

	<body>
		<div id="inputContainer">
			대상
			<select id="receiver">
				
			</select>
			<input type="text" id="msg"><button id="sendMsg">전송</button>
		</div>
		
		<div id="msgContainer">
			
		</div>
		
		<script>
			
			// 소켓 연결을 위해서 js 에서 제공하는 WebSocket 객체를 생성..
			// 매개변수 있는 생성자를 이용 매개변수에는 연결할 서버 주소를 문자열로 대입
			// 주소는 패턴을 정해놨음..
			// http 방식, https 방식			
			// ws : http 프로토콜 이용시..
			// ex) ws://ip주소 & 도메인이름:포트/프로젝트주소/mapping 주소
			// wss : https 프로토콜 이용시
			// ex) wss://ip주소 & 도메인이름:포트/프로젝트주소/mapping 주소
			const websocket = new WebSocket("ws://localhost:9090/${pageContext.request.contextPath}/chatting");
			const loginMemberId = "${loginMember.userId}";
			
			// socket 에 필요한 속성에 이벤트핸들러를 등록 해준다.
			websocket.onopen = (e) => {
				// 서버와 접속된 후 자동으로 실행되는 함수
				$("#msgContainer").html("<h4>채팅서버 접속 완료</h4>");
				
				const access = new Message("connect", loginMemberId, '', '', '');
				websocket.send(JSON.stringify(access));
			}
			
			websocket.onmessage = (e) => {
				// 서버에서 sendMessage() 메소드를 호출하면 실행되는 함수..
				const data = JSON.parse(e.data);
				
				switch(data.type) {
					case "system" :
						addMsgSystem(data);
					break;
					case "msg" :
						printMsg('${loginMember.userId}', data);
					break;
					case "attendClient" :
						attendClient(JSON.parse(data.msg));
					break;
				}
				
				
			};
			
			websocket.onclose = (e) => {
				// 서버와 연결이 차단되었을 때 실행되는 함수
				
			};
			
			
			
			$("#sendMsg").click(() => {
				const msg = $("#msg").val();
				// csv 방식으로 전송하기
				// sender, receiver, msg
				
				const sender = "${loginMember.userId}";
				const receiver = $('#receiver').val();
				const sendMessage = new Message("msg", sender, receiver, msg);
				// 메시지를 서버에 전송하려면 send() 함수를 이용한다.
				// - 서버의 handleTextMessage 메소드가 실행됨.
				websocket.send(JSON.stringify(sendMessage)); 				
			});
			
			/*
			function Message(type,sender,receiver,msg,room) {
				this.type = type;
				this.sender = sender;
				this.receiver = receiver;
				this.msg = msg;
				this.room = room;
			} 
			*/
			
			class Message {
				constructor(type, sender, receiver, msg, room) {
					this.type = type;
					this.sender = sender;
					this.receiver = receiver;
					this.msg = msg;
					this.room = room;
				}	
			}
		</script>
	</body>
</html>







