<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>강의 보기</title>
</head>
<body>

<%
out.flush();
request.getRequestDispatcher("/header.jsp").include(request,response);
%>
    
<h1>강의 보기</h1>
<form action='update' method='post'>
<input type='hidden' name='no' value='1'>
<table border='1'>
<tr>
    <th>강의명</th>
    <td><input type='text' name='title' value='hihi2'></td>
</tr>
<tr>
    <th>시작일</th>
    <td><input type='date' name='startDate' value='2018-05-14'></td>
</tr>
<tr>
    <th>종료일</th>
    <td><input type='date' name='endDate' value='2018-05-15'></td>
</tr>
<tr>
    <th>강의실</th>
    <td><input type='text' name='room' value='200'></td>
</tr>
</table>
<p>
<a href='list'>목록</a>
<button>변경</button>
<a href='delete?no=1'>삭제</a>
</p>
</form>
</body>
</html>
    