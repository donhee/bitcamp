<%@page import="bitcamp.java106.pms.domain.Team"%>
<%@page import="java.util.List"%>
<%@page import="bitcamp.java106.pms.domain.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>팀 회원 보기</title>
</head>
<body>
<h2>회원 목록(MVC)</h2>
<%
Team team = (Team) request.getAttribute("team");
%>
<form action='member/add' method='post'>
<input type='text' name='memberId' placeholder='회원 아이디'>
<input type='hidden' name='teamName' value='<%=team.getName()%>'>
<button>추가</button>
</form>
<table border='1'>
<tr><th>아이디</th><th>이메일</th><th> </th></tr>
<%
List<Member> list = (List<Member>) request.getAttribute("list");
for (Member member : list) {
%>
<tr><td><%=member.getId()%></td><td><%=member.getEmail()%></td><td><a href='member/delete?teamName=<%=team.getName()%>&memberId=<%=member.getId()%>'>삭제</a></td></tr>
<%}%>
</table>
</body>
</html>