<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<meta http-equiv='Refresh' 
    content='5;url=<%=request.getHeader("Referer")%>'>
<title>실행 오류</title>
</head>
<body>
<h1>실행오류!</h1>
<pre>
<%=exception%>
</pre>
</body>
</html>
    