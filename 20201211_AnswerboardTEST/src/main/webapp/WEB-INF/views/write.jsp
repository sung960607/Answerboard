<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글입력</title>
</head>
<body>
<form action="./writeboard.do" method="post">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" value="${vo.id}" readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" required> </td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="10" name="content" required></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="글입력">
			</td>
		</tr>
	</table>
</form>
</body>
</html>