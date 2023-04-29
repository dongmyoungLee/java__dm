<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
   <jsp:param value="MainPage" name="title"/>
</jsp:include>
<section id="content">
   <form action="${pageContext.request.contextPath}/loginend.do" method="post">
      <input type="text" name="userId" class="form-control"><br>
      <input type="password" name="pw" class="form-control"><br>
      <button type="submit" class="btn btn-outline-success">login</button>
      <button type="button" class="btn btn-outline-success">cancel</button>
   </form>
   
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>