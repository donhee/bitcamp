// div#header 태그에 /html/header.html 내용을 삽입한다.

$.get("/bitcamp-java-project/html2/header.html", (data) => {
	$("#header").html(data);
	loadLoginUser();
});

function loadLoginUser() {
	$.getJSON("/bitcamp-java-project/json/auth/loginUser", (data) => {
		if (data == "") 
			location.href = "/bitcamp-java-project/html2/auth/login.html";
		else {
			$("#username").text(data.id); 
			$("#logoutBtn").click((e) => {
				//window.alert("logout");
				e.preventDefault(); // 클릭했을 때 원래 a 태그가 하던 일(href="~~")을 멈춰라!
				$.get("/bitcamp-java-project/json/auth/logout", () => {
					location.href = "/bitcamp-java-project/html2/auth/login.html";
				});
				
			});
		}
	});
}