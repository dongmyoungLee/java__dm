function addMsgSystem(msg) {
	const $h3 = $("<h3>").css("textAlign", "center").text(`===== ${msg.msg} =====`);
	$("#msgContainer").append($h3);
	/*
	if(msg.msg.includes("입장")) {
		$("#receiver").append(`<option value='${msg.sender}'>${msg.sender}</option>`);
	} else if(msg.msg.includes("퇴장")) {
		$("#receiver").children().each((i, e) => {

			debugger
			
			if(msg.sender == e.val()) {
			e.remove();
			}
		});
	}
	*/
}

function printMsg(loginId, msg) {
	const $p = $("<p>").css("textAlign", loginId == msg.sender ? "left" : "right").text(`${msg.sender} : ${msg.msg}`);
	$("#msgContainer").append($p);
}

function attendClient(data) {

	console.log(data);
	
	$("#receiver").html("<option selected disabled value=''>=== 전체 ===</option>");
	
	data.forEach(e => {
		$("#receiver").append(`<option value='${e}'>${e}</option>`);
	});
}