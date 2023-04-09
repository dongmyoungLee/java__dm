<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="MainPage" name="title"/>
</jsp:include>


<section id="board-container" class="container">
    <p>총 ${totalContents }건의 게시물이 있습니다.</p>
    
    <table id="tbl-board" class="table table-striped table-hover">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>첨부파일</th>
            <th>조회수</th>
        </tr>
        <c:if test="${empty boards }">
          	<tr>
          		<td colspan="6" scope="col">등록된 게시물이 없습니다.</td>
          	</tr>
          </c:if>
          
          <c:if test="${not empty boards }">
			  <c:forEach var="board" items="${boards }">
				<tr>
					<td scope="col">${board.boardNo }</td>
					<td style="cursor:pointer" scope="col" onClick="location.assign('${path}/board/boardDetail.do?pk=${board.boardNo}')">${board.boardTitle }</td>
					<td scope="col">${board.boardWriter.userName }</td>
					<td scope="col">${board.boardDate }</td>
					<td scope="col">
						<c:if test="${empty board.files}">첨부파일 없음</c:if>
						<c:if test="${not empty board.files}">
							<img src="${path}/resources/images/boardimg.png" width="25" style="cursor:pointer" />
							<span>(${board.files.size()})</span>
						</c:if>
					</td>
					<td scope="col">${board.boardReadCount }</td>
				</tr>
			  </c:forEach>
		  </c:if>
    </table>
    <div id="pageBar">
    	${pageBar}
    </div>
</section>


<jsp:include page="/WEB-INF/views/common/footer.jsp" />