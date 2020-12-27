<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일 보드</title>
</head>
<body>
<table>
	<tr>
		<th>아이디</th>
		<th>제목</th>
		<th>내용</th>
	</tr>
	<tr>
		<td>${list.get(0).id}</td>
		<td>${list.get(0).title}</td>
		<td>${list.get(0).content}</td>
	</tr>
		
	<tr>
		<td colspan="2">
			<input type="button" value="글수정" onclick="location.href='./modify.do?seq=${list.get(0).seq}'">
			<input type="button" value="글삭제" onclick="location.href='./delflag.do?seq=${list.get(0).seq}'">
			<input type="button" value="답글달기" onclick="location.href='./reply.do?seq=${list.get(0).seq}'">
		</td>
	</tr>
</table>

	
</body>
</html>