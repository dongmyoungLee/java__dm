<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.member.vo.Member" %>
<%
	Member member = (Member)session.getAttribute("loginMember");
%>
<%@ include file="/views/common/header.jsp" %>
	<section id=enroll-container>
        <h2>회원 정보 수정</h2>
        <form action="<%=request.getContextPath()%>/member/enrollMemberEnd.do" method="post" onsubmit="" >
        <table>
         <tr>
            <th>아이디</th>
            <td>
               <input type="text" placeholder="4글자이상" name="userId" id="userId_" readonly value="<%=member.getUserid()%>">
            </td>
         </tr>
         <tr>
            <th>패스워드</th>
            <td>
               <input type="password" name="password" id="password_" readonly value="****" ><br>
            </td>
         </tr>
         <tr>
            <th>패스워드확인</th>
            <td>   
               <input type="password" id="password_2" readonly value="****"><br>
            </td>
         </tr>  
         <tr>
            <th>이름</th>
            <td>   
            <input type="text"  name="userName" id="userName" value="<%=member.getUserName()%>"><br>
            </td>
         </tr>
         <tr>
            <th>나이</th>
            <td>   
            <input type="number" name="age" id="age" value="<%=member.getAge()%>"><br>
            </td>
         </tr> 
         <tr>
            <th>이메일</th>
            <td>   
               <input type="email" placeholder="abc@xyz.com" name="email" id="email" value="<%=member.getEmail()%>"><br>
            </td>
         </tr>
         <tr>
            <th>휴대폰</th>
            <td>   
               <input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" required value="<%=member.getPhone()%>"><br>
            </td>
         </tr>
         <tr>
            <th>주소</th>
            <td>   
               <input type="text" placeholder="" name="address" id="address" value="<%=member.getAddress()%>"><br>
            </td>
         </tr>
         <tr>
            <th>성별 </th>
            <td>
               <input type="radio" name="gender" id="gender0" value="M" <%=member.getGender().equals("M") ? "checked" : "" %>>
               <label for="gender0">남</label>
               <input type="radio" name="gender" id="gender1" value="F" <%=member.getGender().equals("F") ? "checked" : "" %>>
               <label for="gender1">여</label>
            </td>
         </tr>
         <tr>
            <th>취미 </th>
            <td>
               <input type="checkbox" name="hobby" <%=member.getHobby().contains("운동") ? "checked" : "" %> id="hobby0"><label for="hobby0" value="운동">운동</label>
               <input type="checkbox" name="hobby" <%=member.getHobby().contains("등산") ? "checked" : "" %> id="hobby1" ><label for="hobby1"  value="등산">등산</label>
               <input type="checkbox" name="hobby" <%=member.getHobby().contains("독서") ? "checked" : "" %> id="hobby2" ><label for="hobby2"  value="독서">독서</label><br />
               <input type="checkbox" name="hobby" <%=member.getHobby().contains("게임") ? "checked" : "" %> id="hobby3"><label for="hobby3"  value="게임">게임</label>
               <input type="checkbox" name="hobby" <%=member.getHobby().contains("여행") ? "checked" : "" %> id="hobby4" ><label for="hobby4"  value="여행">여행</label><br />
            </td>
         </tr>
      </table>
      <input type="submit" value="수정" >
      <input type="reset" value="취소" onClick="location.replace('<%=request.getContextPath()%>')">
        </form>
    </section>
<%@ include file="/views/common/footer.jsp" %>