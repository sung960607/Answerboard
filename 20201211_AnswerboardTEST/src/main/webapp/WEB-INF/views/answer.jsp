<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>answerboard입니다.</title>
</head>
<script type="text/javascript">
	function checkAll(check) {
		var check = check;
		var chk = new Array();
		chk = document.getElementsByName("chk");

		if (check == true) {
			for (var i = 0; i < chk.length; i++) {
				chk[i].checked = true;
			}
		}
		if (check == false) {
			for (var i = 0; i < chk.length; i++) {
				chk[i].checked = false;
			}
		}
	}
</script>
<body>
<form action="./mutilDel.do" method="post">
	<table>
		<tr>
			<th><input type="checkbox" name="checkall"
				onclick="checkAll(this.checked)"></th>
			<th>연번</th>
			<th>아이디</th>
			<th>글제목</th>
			<th>글 내용</th>
		</tr>
		<c:forEach var="answer" items="${lists}" varStatus="vs">
			<tr>
				<td><input type="checkbox" name="chk" value="${answer.seq}"></td>
				<td>${vs.count}</td>
				<td>${answer.id}</td>
				<td><a href="./detail.do?seq=${answer.seq}">${answer.title}</a></td>
				<td>${answer.content}</td>
			</tr>
		</c:forEach>
		<tr>
			<td><input type="button" value="글입력"
				onclick="location.href='./write.do'"></td>
			<td><input type="submit" value="다중삭제"></td>
		</tr>
	</table>
</form>

</body>
</html>