<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="MainPage" name="title"/>
</jsp:include>

<style>
	div#demo-container{
      width:50%;
      padding:15px;
      margin:0 auto;
      border:1px solid lightgray;
      border-radius:10px;
   }
</style>

<section id="content">
   <div id="demo-container">
   	  <h2>파라미터 테스트 페이지</h2>
      <form id="devFrm" method="post">
         <div class="form-group row">
         <label for="devName" class="col-sm-2 col-form-label">이름</label>
         <div class="col-sm-10">
            <input type="text" class="form-control" id="devName" name="devName">
         </div>
         </div>
         <div class="form-group row">
         <label for="devAge" class="col-sm-2 col-form-label">나이</label>
         <div class="col-sm-10">
            <input type="number" class="form-control" id="devAge" name="devAge">
         </div>
         </div>
         <div class="form-group row">
	         <label for="devEmail" class="col-sm-2 col-form-label">이메일</label>
	         <div class="col-sm-10">
	            <input type="email" class="form-control" id="devEmail" name="devEmail">
	         </div>
         </div>
         <div class="form-group row">
            <label class="col-sm-2 col-form-label">성별</label>
            <div class="col-sm-10">
               <div class="form-check form-check-inline">
               <input class="form-check-input" type="radio" name="devGender" id="devGender0" value="M">
               <label class="form-check-label" for="devGender0">남</label>
               </div>
               <div class="form-check form-check-inline">
               <input class="form-check-input" type="radio" name="devGender" id="devGender1" value="F">
               <label class="form-check-label" for="devGender1">여</label>
               </div>
            </div>
         </div>
         <div class="form-group row">
            <label class="col-sm-2 col-form-label">개발언어</label>
            <div class="col-sm-10">
               <div class="form-check form-check-inline">
	               <input class="form-check-input" type="checkbox" name="devLang" id="devLang0" value="Java">
	               <label class="form-check-label" for="devLang0">Java</label>
	               </div>
	               <div class="form-check form-check-inline">
	               <input class="form-check-input" type="checkbox" name="devLang" id="devLang1" value="C">
	               <label class="form-check-label" for="devLang1">C</label>
	               </div>
	               <div class="form-check form-check-inline">
	               <input class="form-check-input" type="checkbox" name="devLang" id="devLang2" value="Javascript">
	               <label class="form-check-label" for="devLang2">Javascript</label>
               </div>
            </div>
         </div>
      <div class="form-group row">
        <label for="birthday" class="col-sm-2 col-form-label">생년월일</label>
        <div class="col-sm-10">
           <input type="date" class="form-control" id="birthday" name="birthday">
        </div>
       </div>
      </form>
   	  <div class="form-group row">
	    <div class="col-sm-12">
	    	<button type="button" class="col-sm-12 btn btn-outline-primary" onclick="requestSend('demo/demo1.do')">
	    		Spring을 Servlet 처럼 이용하기
	    	</button>
	    </div>
   	  </div>
   	  <div class="form-group row">
	    <div class="col-sm-12">
	    	<button type="button" class="col-sm-12 btn btn-outline-primary" onclick="requestSend('demo/demo2.do')">
	    		1:1로 매핑해서 데이터 받기
	    	</button>
	    </div>
   	  </div>
   	  <div class="form-group row">
	    <div class="col-sm-12">
	    	<button type="button" class="col-sm-12 btn btn-outline-primary" onclick="requestSend('demo/demo3.do')">
	    		@RequestParam 이용하기
	    	</button>
	    </div>
   	  </div>
   	  <div class="form-group row">
	    <div class="col-sm-12">
	    	<button type="button" class="col-sm-12 btn btn-outline-primary" onclick="requestSend('demo/demo4.do')">
	    		Comaand 이용하기
	    	</button>
	    </div>
   	  </div>
   </div>
</section>

<script>
	const requestSend = (url) => {
		console.log('dddd')
		$("#devFrm").attr("action", "${path}/"+url);
		$("#devFrm").submit();
	}
</script>


<jsp:include page="/WEB-INF/views/common/footer.jsp" />