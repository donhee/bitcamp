<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam07</title>
</head>
<body>

<h1>JSTL - c:choose - 여러개의 조건이 있을때 </h1>
<pre>
- if ~ else if ~ else if ~ else 또는 switch 기능을 하는 자바 코드를 만든다.
&lt;c:choose>
    &lt;c:when test="true or false">콘텐츠&lt;/c:when>
    &lt;c:when test="true or false">콘텐츠&lt;/c:when>
    &lt;c:when test="true or false">콘텐츠&lt;/c:when>
    &lt;c:otherwise>콘텐츠    &lt;/c:otherwist>

- test 속성의 값 : true 속성 또는 false 값을 리턴하는 EL 태그가 온다.
- var 속성 : 조건의 결과, 즉 true 또는 false, 저장할 때 사용하는 이름이다.
- scope 속성 : 조건의 결과를 저장할 저장소
</pre>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="age" value="-10"/>
<c:choose>
	<c:when test="${age > 0 && age < 19}">
	    미성년입니다.
	</c:when>
	
	<c:when test="${age >= 19 and age < 65}">
	    성년입니다.
	</c:when>
	
	<c:when test="${age >= 65}">
        노인입니다.
    </c:when>
	
	<c:otherwise>
	   나이 값이 없거나 잘못된 값입니다.
	</c:otherwise>
</c:choose>


</body>
</html>







