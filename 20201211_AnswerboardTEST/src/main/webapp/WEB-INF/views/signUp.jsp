<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	function duplication() {
		var id = $("#id").val();
		$.ajax({
			type : "POST",
			url : "./idCheck.do",
			data : "id=" + id,
			async : true,
			success : function(msg) {
				alert(msg.isc);
				if (msg.isc == "false") {
					alert("사용할 수 있는 아이디 입니다.");
					$("#checkval").val(1);
				} else {
					alert("이미 있는 아이디 입니다.");
				}
			},
			error : function() {
				alert('잘못된 요청 값 입니다.');
			}
		});
	}

	function checkoutvalue() {
		alert($("#checkval").val());
		if($("#checkval").val()==1){
			return true;
		}else{
		return false;
		}
	}
</script>
<body>
	<form action="./signUpMember.do" method="post"
		onsubmit="return checkoutvalue();">
		<input type="hidden" id="checkval" name="checkval" value="0">
		<table>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" min="5" max="20" required>

				</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" id="id" name="id" required> <input
					type="button" onclick="duplication()" value="중복체크"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="회원가입"> <input
					type="button" value="취소" onclick="javascript:history.back(-1)">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>