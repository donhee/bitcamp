<%@page import="java.util.ArrayList"%>
<%@page import="jsp.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam03_5</title>
</head>
<body>
<h1>JSP 전용 태그 : useBean + type + class</h1>
<pre>
type과 class속성을 둘다 지정했을 때 

type 속성
  generic 표현을 사용할 수 있다. --> 변수를 사용할때 사용하는 타입 
class 속성
  generic 표현을 사용할 수 없다. --> 빈 값이 들어올때 에러를 띄우게 하지말고 빈 화면을 띄우기 위해
</pre>

<%
Member obj = new Member();
obj.setId("홍길동");
obj.setEmail("hong@test.com");
obj.setPassword("1111");

Member obj2 = new Member();
obj2.setId("임꺽정");
obj2.setEmail("hong2@test.com");
obj2.setPassword("2222");

ArrayList<Member> arr = new ArrayList<>();
arr.add(obj);
arr.add(obj2);

pageContext.setAttribute("list", arr);
%>

<h2>type과 class 속성을 동시에 설정하기</h2>
<jsp:useBean id="list" 
    type="java.util.List<Member>"
    class="java.util.ArrayList"></jsp:useBean> <%-- <Member> 지정 안해주면 : 예외 발생 : Type mismatch: cannot convert from element type Object to Member --%>
<%-- 자바 코드로는:
//t type 속성 값은 변수를 선언할 때 사용한다.
java.util.List<Member> list = (java.util.ArrayList) pageContext.getAttribute("list");
if (list == null) {
  // class 속성 값은 객체를 생성할 때 사용한다.
  list = new java.util.ArrayList();
  pageContext.setAttrivute("list", list);
}
 --%>
<%
for (Member member : list) { 
%>
아이디: <%=member.getId() %><br>
이메일: <%=member.getEmail() %><br>
암호:  <%=member.getPassword() %><br>
<%}%>
</body>
</html>