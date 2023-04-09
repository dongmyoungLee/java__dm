<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="메모리스트" name="title"/>
</jsp:include>

<style>
    div#memo-container{width:60%; margin:0 auto;}
</style>

<section id="content">

	<div id="memo-container">
        <form action="${path}/memo/insertMemo.do" method="post" class="form-inline">
            <input type="text" class="form-control col-sm-6" name="memo" placeholder="메모" required/>&nbsp;
            <input type="password" class="form-control col-sm-2" name="password" maxlength="4" placeholder="비밀번호" required/>&nbsp;
            <button class="btn btn-outline-success" type="submit">저장</button>
        </form>
    </div>
    
     <table class="table">
     	  
          <tr>
              <th scope="col">번호</th>
              <th scope="col">메모</th>
              <th scope="col">날짜</th>
              <th scope="col">비고</th>
          </tr>
          
          <c:if test="${empty memos }">
          	<tr>
          		<td colspan="4" scope="col">등록된 메모가 없습니다.</td>
          	</tr>
          </c:if>
          
          <c:if test="${not empty memos }">
			  <c:forEach var="memo" items="${memos }">
				<tr>
					<td scope="col">${memo.memoNo }</td>
					<td scope="col">${memo.memo }</td>
					<td scope="col">${memo.memoDate }</td>
					<td scope="col">
						<button class="btn btn-outline-primary">수정</button>
              			<button class="btn btn-outline-danger">삭제</button>
					</td>
				</tr>
			  </c:forEach>
		  </c:if>
		  
      </table>
</section>


<jsp:include page="/WEB-INF/views/common/footer.jsp" />