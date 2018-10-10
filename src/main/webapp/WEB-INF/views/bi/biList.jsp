<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<script>
window.addEventListener('load',function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/bi');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var res = JSON.parse(xhr.responseText);
				var html = '';
				for(var bi of res){
					html += '<tr>';
					html += '<td>' + bi.binum + '</td>';
					html += '<td><input type="text" name="bititle'+ bi.binum + '" value="'+ bi.bititle +'"></td>';
					html += '<td><input type="text" name="bitext'+ bi.binum + '" value="'+ bi.bitext +'"></td>';
					html += '<td><input type="text" name="bifile'+ bi.binum + '" value="'+ bi.bifile +'"></td>';
					html += '<td>' + bi.bicredat + '</td>';
					html += '<td>' + bi.bimoddat + '</td>';
					html += '<td>' + bi.uinum + '</td>';
					html += '<td><button onclick="boardUpdate('+ bi.binum +')">수정</button>';
					html += '<button onclick="boardDelete('+ bi.binum +')">삭제</button></td>';
					html += '</tr>';
				}
				document.querySelector('#biBody').insertAdjacentHTML('beforeend',html);
			}else{
				
			}
		}
	}
	xhr.send();
});
</script>
<head>
<meta charset="utf-8">
<title>스프링테스트</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글</th>
				<th>파일</th>
				<th>게시일</th>
				<th>수정일</th>
				<th>작성자</th>
				<th>수정/삭제</th>
			</tr>
		</thead>
		<tbody id="biBody">

		</tbody>
	</table>
	<script>
function boardUpdate(binum){
	var bititle = document.querySelector('input[name=bititle' + binum + ']').value;
	var bitext = document.querySelector('input[name=bitext' + binum + ']').value;
	var bifile = document.querySelector('input[name=bifile'+binum+']').value;
	var param = {binum:binum, bititle:bititle, bitext:bitext, bifile:bifile};
	var xhr = new XMLHttpRequest();
	var url = '/bi';
	xhr.open('PUT', url);
	xhr.setRequestHeader('Content-Type','application/json');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				if(xhr.responseText=="1"){
					alert("수정성공");
					location.href="/uri/bi/biList";
				}
			}else{
				alert("수정실패");
			}
		}
	}
	xhr.send(JSON.stringify(param));
}
function boardDelete(binum){
	var xhr = new XMLHttpRequest();
	var url = '/bi/' + binum;
	xhr.open('DELETE', url);
	xhr.setRequestHeader('Content-Type','application/json');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				if(xhr.responseText=="1"){
					alert("삭제성공");
					location.href="/uri/bi/biList";
				}
			}else{
				alert("삭제실패");
			}
		}
	}
	alert(xhr.readyState);
	xhr.send(JSON.stringify(param));
}
</script>
</body>
</html>