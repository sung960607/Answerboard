<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글달기</title>
</head>
<body>
<form action="./replyIn.do" method="post">
<input type="hidden" name="seq" value="${seq}">
<table>
	<tr>
		<th>Root글 아이디</th>
		<td><input type="text" value="${id}" readonly></td>
	</tr>
	<tr>
		<th>답글아이디</th>
		<td><input type="text" name="id" value="${vo.id}" readonly> </td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type="text" name="title"> </td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="10" name="content"></textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="완료">
		</td>
	</tr>
</table>
</form>
</body>
</html>