<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="게시글 작성" name="title"/>
</jsp:include>

<style>
    div#board-container{width:400px; margin:0 auto; text-align:center;}
    div#board-container input{margin-bottom:15px;}
</style>
<section id="content">
	<div id="board-container">
        <form name="boardFrm" action="${path}/board/boardWriteEnd.do" method="POST" enctype="multipart/form-data">
            <input type="text" class="form-control" placeholder="제목" name="boardTitle" id="boardTitle" required>
            <input type="text" class="form-control" placeholder="아이디 (4글자이상)" name="boardWriter" value="${loginMember.userId}" readonly required>
            <div>
	            <button type="button" class="btn btn-outline-success" onClick="addFile(event);">추가</button>
	            <button type="button" class="btn btn-outline-danger" onClick="delFile(event);">삭제</button>
            </div>
            <div class="input-group mb-3" style="padding:0px;">
                <div class="input-group-prepend" style="padding:0px;">
                    <span class="input-group-text">첨부파일1</span>
                </div>
                <div class="custom-file">
                    <input type="file" class="custom-file-input" name="upFile" id="upFile1">
                    <label class="custom-file-label" for="upFile1">파일을 선택하세요</label>
                </div>
            </div>
            <textarea class="form-control" name="boardContent" placeholder="내용" required></textarea>
            <br />
            <input type="submit" class="btn btn-outline-success" value="저장" >
        </form>
    </div>
</section>

<script>
	$(() => {
		$("[name=upFile]").change(e => {
			const fileName = e.target.files[0].name;
			
			$(e.target).next(".custom-file-label").text(fileName);
		});
	});
	/*
	const addDelhandler = (() => {
		let count = 1;
		
		return [
			e => {
				if(count < 5) {
					const addFileContainer = $(e.target).parent().next().clone(true);
					$(addFileContainer).find("span.input-group-text").text("첨부파일" + (++count));
					$(addFileContainer).find("input[type=file]").attr("id", "upfile" + count);
					$(addFileContainer).find("label.custom-file-label").attr("for", "upfile" _ count);
					$("div .input-group").last().after(addFileContainer);	
				} else {
					alert("첨부파일은 5개까지 가능합니다.");
				}
			},
			e => {
				if($("div.input-group").length > 1) {
					$("div.input-group").last().remove();
				}
			}
		]	
	})();
	

	const addFile = addDelhandler[0];
	const delFile = addDelhandler[1];
	*/
	
   const addDelhandler=(()=>{
	      let count=1;
	      return [
	         e=>{
	         if(count<5){
	            const addFileContainer=$(e.target).parent().next().clone(true);
	            $(addFileContainer).find("span.input-group-text")
	            .text("첨부파일"+(++count));
	            $(addFileContainer).find("input[type=file]").val("").attr("id","upFile"+count);
	            $(addFileContainer).find("label.custom-file-label")
	            .attr("for","upFile"+count).text("파일을 선택하세요.");
	            $("div.input-group").last().after(addFileContainer);
	         }else{
	            alert("첨부파일은 5개만 가능합니다.");
	         }
	      },
	      e=>{
	         if($("div.input-group").length>1){ 
	            $("div.input-group").last().remove();
	            count--;
	         }
	      }];
	   })();
   const addFile=addDelhandler[0];
   const delFile=addDelhandler[1];
		
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />