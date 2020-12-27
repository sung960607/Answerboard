<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
 window.ready=function(){
	 
 }
</script>
<body>
<form action="./modifyinsert.do" method="post">
<input type="hidden" name="seq" value="${list.get(0).seq}">
	<table>
		<tr>
			<th>아이디</th>
			<th>제목</th>
			<th>내용</th>
		</tr>
		<tr>
			<td><input type="text" name="id" value="${list.get(0).id}" required></td>
			<td><input type="text" name="title" value="${list.get(0).title}" required> </td>
			<td><textarea rows="10" cols="10" name="content" required>${list.get(0).content}</textarea></td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="submit" value="글입력">
			</td>
		</tr>
	</table>
</form>
</body>
</html>