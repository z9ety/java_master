<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
	li {
		list-style: none;
	}
	.pagination {
	  display: inline-block;
	}
	
	.pagination a {
	  color: black;
	  float: left;
	  padding: 8px 16px;
	  text-decoration: none;
	}
	
	.pagination a.active {
	  background-color: #4CAF50;
	  color: white;
	}
	
	.pagination a:hover:not(.active) {background-color: #ddd;}
	</style>

	<h3>상세화면</h3>

	<form name="myForm" action="modifyForm.do">
		<input type="hidden" name="bno" value="${vo.boardNo}">
		<table class="table">
			<tbody>
				<tr>
					<td>글번호</td>
					<td colspan="3">${vo.boardNo}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="3">${vo.title}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="3">${vo.content}</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td colspan="3">${vo.writer}</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value ="${vo.writerDate}" /></td>
					<td>조회수</td>
					<td>${vo.clickCnt}</td>
				</tr>
				<tr>
					<td>이미지</td>
					<td colspan="3">
						<c:if test="${!empty vo.image }">
							<img width="150px" src="images/${vo.image }">
						</c:if>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<c:choose>
							<c:when test="${logName eq vo.writer }">
								<input type="submit" value="수정">
								<input type="button" onclick="deleteFun()" value="삭제">
							</c:when>
							<c:otherwise>
								<input type="submit" disabled value="수정">
								<input type="button" disabled onclick="deleteFun()" value="삭제">
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<br>
	<div id="input">
	댓글내용: <input type="text" id="content"><button id="addReply">등록</button>
	<p />
	</div>
	<p>댓글목록</p>
	<div id="show">
		<ul id="list">
			<!-- <li><span></span></li> -->
			
		</ul>
	</div>
	<!-- 페이징 처리. -->
	<!-- ${page} -->
	<div id="paging" class="pagination">
		
	</div>
	<a href="boardList.do">글목록으로</a>
	<script src="js/service.js"></script>
	<script>
	function deleteFun(){
		console.log(window);
		document.forms.myForm.action = "removeForm.do";
		document.forms.myForm.submit();
	}
	const bno = '${vo.boardNo}';
	let ul = document.querySelector('#list');
	// 페이지 클릭하면 페이지의 데이터 보여주도록.
	let pageInfo = 1;
	function pageList(e){
		e.preventDefault();
		pageInfo = this.getAttribute("href");
		showList(pageInfo);
		
		// 페이지를 생성하는 함수를 호출.
		pagingList(pageInfo);
	}
	
	// Ajax호출.
	function showList(page){
		ul.innerHTML = '';
		const xhtp = new XMLHttpRequest();
		xhtp.open('get', 'replyListJson.do?bno='+ bno + "&page=" + page)
		xhtp.send()
		xhtp.onload = function(){
			let data = JSON.parse(xhtp.responseText); // json문자열 -> 객체.
			data.forEach(reply => {
				let li = makeLi(reply);
				ul.appendChild(li);
			})
		}
	} // end of showList.
	showList(pageInfo);

	// 페이지 생성.
	let paging = document.querySelector('#paging');
	pagingList();

	function pagingList(page = 1){
		paging.innerHTML = '';
		let pagingAjax = new XMLHttpRequest();
		pagingAjax.open('get', 'pagingListJson.do?bno=' + bno + "&page=" + page);
		pagingAjax.send();
		pagingAjax.onload = function(){
			let result = JSON.parse(pagingAjax.responseText);
			//이전.
			if(result.prev)	{
				let aTag = document.createElement('a');
				aTag.href = result.startPage - 1;
				aTag.innerText = '이전';
				aTag.addEventListener('click', pageList);
				paging.appendChild(aTag);
			}
			for (let p = result.startPage; p <= result.lastPage; p++){
				let aTag = document.createElement('a');
				if (p == page){
					aTag.setAttribute('class','active');
				}
				aTag.href = p;
				aTag.innerText = p;
				aTag.addEventListener('click', pageList);
				paging.appendChild(aTag);
				
			}
			// 다음.
			if(result.next)	{
				let aTag = document.createElement('a');
				aTag.href = result.lastPage + 1;
				aTag.innerText = '다음';
				aTag.addEventListener('click', pageList);
				paging.appendChild(aTag);
			}
		}
	} //end of pagingList.
	
	// 등록버튼 클릭 이벤트 생성.
	// document.querySelector('#addReply').addEventListener('click', function(){});
	document.querySelector('#addReply').onclick = function(){
		
		let reply = document.querySelector('#content').value;
		let replyer = '${logId}';
		
		const addAjax = new XMLHttpRequest();
		addAjax.open('get', 'addReplyJson.do?reply='+reply+'&replyer='+replyer+'&bno='+bno);
		addAjax.send();
		addAjax.onload = function(){
			let result = JSON.parse(addAjax.responseText);
			if (result.retCode == 'OK'){
				let reply = result.vo;
				let li = makeLi(reply);
				ul.appendChild(li);
				
				showList(1);
				pagingList(1);
				
			} else if(result.retCode == 'NG'){
				alert('처리중 에러');
			}
			document.querySelector('#content').value = '';
		}
	}
	</script>
