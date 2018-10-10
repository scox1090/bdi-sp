<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>스프링테스트</title>
</head>
<script>
window.addEventListener('load',function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/japan');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var res = JSON.parse(xhr.responseText);
				var html = '';
				for(var j of res){
					html += '<tr>';
					html += '<td>' + j.jpnum + '</td>';
					html += '<td><input type="text" name="jpname' + j.jpnum + '" value="' + j.jpname + '"></td>';
					html += '<td><input type="text" name="jpdesc' + j.jpnum + '" value="' + j.jpdesc + '"></td>';
					html += '<td><button onclick="japanUpdate('+j.jpnum+')">수정</button>';
					html +='<button onclick="japanDelete('+j.jpnum+')">삭제</button></td>';
					html += '</tr>';
				}
				document.querySelector('#jpBody').insertAdjacentHTML('beforeend',html);
			}else{
				
			}
		}
	}
	xhr.send();
});

</script>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>설명</th>
				<th>수정/삭제</th>
			</tr>
		</thead>

		<tbody id="jpBody">
			
		</tbody>
	</table>

	<button onclick="japanAdd()">제펜추가</button>
	<script>
		function japanUpdate(jpnum){
			var jpname = document.querySelector('input[name=jpname' + jpnum + ']').value;
			var jpdesc = document.querySelector('input[name=jpdesc' + jpnum + ']').value;
			var param = {jpnum:jpnum, jpname:jpname,jpdesc:jpdesc};
			var xhr = new XMLHttpRequest();
			var url = "/japan";
			xhr.open('PUT', url);
			xhr.setRequestHeader('Content-Type','application/json');
			xhr.onreadystatechange = function(){  
				if(xhr.readyState==4){
					if(xhr.status=200){
							if(xhr.responseText=="1"){
								alert('수정성공!');
								location.href='/uri/japan/list';
							}
					}else{
						alert('수정실패');
					}
				}
			}
			alert(JSON.stringify(param));
			xhr.send(JSON.stringify(param));
		}
		
		function japanDelete(jpnum){
			var xhr = new XMLHttpRequest();
			var url = "/japan/" + jpnum;
			xhr.open('DELETE', url);
			xhr.onreadystatechange = function(){  
				if(xhr.readyState==4){
					if(xhr.status=200){
							if(xhr.responseText=='1'){
								alert('삭제성공!');
								location.href='uri/japan/list';
							}
						alert(xhr.responseText);
					}else{
						alert('삭제실패');
					}
				}
			}
			xhr.send();
		}
		
		function japanAdd(){
			var html = '<tr>';
			html += '<td>&nbsp;</td>';
			html += '<td><input type="text" name="jpname" value="${j.jpname}"></td>';
			html += '<td><input type="text" name="jpdesc" value="${j.jpdesc}"></td>';
			html += '<td><button onclick="japanInsert()">저장</button></td>';
			html += '</tr>';
			document.querySelector('tbody').insertAdjacentHTML('beforeend',html);
		}
		
		function japanInsert(){
			var jpname = document.querySelector('input[name=jpname]').value;
			var jpdesc = document.querySelector('input[name=jpdesc]').value;
			var param = {jpname:jpname,jpdesc:jpdesc};
			var xhr = new XMLHttpRequest();
			var url = "/japan";
			xhr.open('POST', url);
			xhr.setRequestHeader('Content-Type','application/json; charset=utf-8');
			xhr.onreadystatechange = function(){  
				if(xhr.readyState==4){
					if(xhr.status=200){
							if(xhr.responseText=="1"){
								alert('저장성공!');
								location.href='/uri/japan/list';
							}
					}else{
						alert('저장실패');
					}
				}
			}
			xhr.send(JSON.stringify(param));
		}
	</script>
</body>
</html>