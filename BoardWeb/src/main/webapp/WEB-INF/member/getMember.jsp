<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>회원상세</h3>

	<form name="admForm" action="">
		<input type="hidden" name="id" value="${vo.id }">
		<table class="table">
			<tbody>
				<tr>
					<td>아이디</td>
					<td colspan="3">${vo.id}</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td colspan="3">${vo.pw}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td colspan="3">${vo.name}</td>
				</tr>
				<tr>
					<td>권한</td>
					<td colspan="3">${vo.responsibility}</td>
				</tr>
				<tr>
					<td>등록한 글목록</td>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td colspan="4" align="center">
								<input type="submit" value="수정">
								<input type="button" onclick="deleteFun()" value="삭제">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<script>
	function deleteFun(){
		console.log(window);
		document.forms.admForm.action = "removeMember.do";
		document.forms.admForm.submit();
	}
	</script>