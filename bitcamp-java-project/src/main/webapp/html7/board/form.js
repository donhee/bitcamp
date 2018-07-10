// 태그에 id를 지정하면 window 객체에 자동 등록한다.
// 따라서 다음과 같이 태그를 찾는 코드를 작성하지 않아도 된다.
/*
var fNo = document.querySelector("#fNo"),
    fTitle = document.querySelector("#fTitle"),
    fContent = document.querySelector("#fContent"),
    fCreatedDate = document.querySelector("#fCreatedDate");
*/
//console.log(window.fTitle);

// 웹 브라우저가 기본으로 제공하는 객체
//console.log(location.href.split("?")[1].split("=")[1]);  // no값 => 예) 24

if (location.href.split("?").length > 1) {
	var tags = $(".input-view");
    tags.css("display", "none");
    
	var no = location.href.split("?")[1].split("=")[1];
	
    $.getJSON(serverRoot + "/json/board/" + no, function(data) {
        $(fNo).val(data.no);
        $(fTitle).val(data.title);
        $(fContent).val(data.content);
        $(fCreatedDate).val(data.createdDate);
    });	
	
	$("#updBtn").click(() => {
		$.post(serverRoot + "/json/board/update", {
			title: $(fTitle).val(),
			content: $(fContent).val(),
			no: $(fNo).val()
		}, () => {
			location.href = "list.html";
		});
	});
	
    $("#delBtn").click(() => {
    	if (window.confirm("삭제하시겠습니까?") == false)
    	   return;
    	
    	$.get(serverRoot + "/json/board/delete", {"no":no}, () => {
    		window.location.href = "list.html";
    	});
    });
	
} else { // 새 글 등록시에는
	var tags = $(".detail-view");
	tags.css("display", "none");
	
	$("#addBtn").click(() => {
		$.post(serverRoot + "/json/board/add", {
			title: $(fTitle).val(),
			content: $(fContent).val()
		}, () => {
			location.href = "list.html";
		});
	});
}

