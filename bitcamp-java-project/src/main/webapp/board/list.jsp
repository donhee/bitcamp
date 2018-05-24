<%@page import="bitcamp.java106.pms.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시물 목록</title>
</head>
<body>
<h1>게시물 목록(MVC)</h1>
<div id='header'>
<a href='/bitcamp-java-project/auth/login'>로그인</a></div>
<p><a href='form.html'>새 글 등록</a></p>
<table border='1'>
<tr>
    <th>번호</th><th>제목</th><th>등록</th>
</tr>
<%
List<Board> list = (List<Board>) request.getAttribute("list");
for (Board board : list) {
%>
<tr>
    <td><%=board.getNo()%></td>
    <td><a href='view?no=<%=board.getNo()%>'><%=board.getTitle()%></a></td>
    <td><%=board.getCreatedDate()%></td>
</tr>
<%}%>
</table>
</body>
</html>
    