function addMsgSystem(msg) {
	const $h3 = $("<h3>").css("textAlign", "center").text(`===== ${msg.msg} =====`);
	$("#msgContainer").append($h3);
}

function printMsg(loginId, msg) {
	const $p = $("<p>").css("textAlign", loginId == msg.sender ? "left" : "right").text(`${msg.sender} : ${msg.msg}`);
	$("#msgContainer").append($p);
}