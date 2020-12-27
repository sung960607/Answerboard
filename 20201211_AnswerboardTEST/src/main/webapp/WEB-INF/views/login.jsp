<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면입니다.</title>
</head>
<body>
<form action="./loginMember.do" method="post">
<table>
<tr>
	<th>아이디</th>
	<td><input type="text" name="id"></td>
</tr>
<tr>
	<th>비밀번호</th>
	<td><input type="password" name="pw"></td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="로그인">
		<a href="./signUp.do">회원가입</a>
	</td>
</tr>
</table>
</form>
</body>
</html>