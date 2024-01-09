
function makeLi(reply = {}) {

	let li = document.createElement('li');
	let span = document.createElement('span');
	span.innerText = '글번호:' + reply.replyNo;
	li.appendChild(span);

	span = document.createElement('span');
	span.innerText = ' 글내용: ' + reply.reply;
	li.appendChild(span);

	span = document.createElement('span');
	span.innerText = ' 작성자: ' + reply.name;
	li.appendChild(span);

	// 삭제버튼.
	let btn = document.createElement('button');
	btn.addEventListener('click', async function() {
		// 댓글번호 삭제 후 화면에서 제거.
		const promise = await fetch('delReplyJson.do?rno=' + reply.replyNo);
		const json = await promise.json();
		try {
			if (json.retCode == 'OK') {
				alert('삭제됨.');
				showList(pageInfo);
			} else if (result.retCode == 'NG') {
				alert('처리중 에러.');
			}
		} catch (err) {
			console.error('예외=>',err)
		}

	})
	btn.innerText = '삭제';
	li.appendChild(btn); // end.

	return li;
}