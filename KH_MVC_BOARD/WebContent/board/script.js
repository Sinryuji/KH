function writeSave() {
	if (document.writeForm.write.value == "") {
		alert("작성자를 입력해 주세요.");
		document.writeForm.write.focus();
		return false;
	}
	if (document.writeForm.subject.value == "") {
		alert("제목을 입력해 주세요.");
		document.writeForm.subject.focus();
		return false;
	}
	if (document.writeForm.content.value == "") {
		alert("내용을 입력해 주세요.");
		document.writeForm.content.focus();
		return false;
	}
	if (document.writeForm.pass.value == "") {
		alert("비밀번호를 입력해 주세요.");
		document.writeForm.pass.focus();
		return false;
	}
}

function deleteSave() {
	if(document.delForm.pass.value == "") {
			alter("비밀번호를 입력하세요.");
			document.delForm.pass.focus();
			return false;
	}
}