const ctx = "/"+ window.location.pathname.split("/")[1];
const form = document.querySelector("form");

form.addEventListener("submit", (e) => {
	e.preventDefault();
})

let joinId = null;
let checkId = null;

function userIdCheck(){
	joinId = document.querySelector("#insertId")
	checkId = joinId.value;
	if(!checkId.trim()){
		alert('값을 입력하세요.')
		return
	}
	fetch(`${ctx}/validateAjax.do`,{
		method: "post",
		headers:{
			"Content-type" : "application/x-www-form-urlencoded; charset=UFT-8"
		},
		body: "insertId="+checkId
	}).then(response => response.text())
	.then(hasId)
	.catch(error => console.log(error))
}

function hasId(check){
	if(!check){
		alert('이미 존재하는 아이디입니다.')
		joinId.style.border = "2px solid crimson"
		joinId.value = ""
		joinId.focus()
		checkId = null;
	}else{
		alert('사용할 수 있는 아이디입니다.')
		joinId.style.border = "2px solid royalblue"
	}
}

function userInsertValidCheck(){
	const inputs = document.querySelectorAll("input")
	const labels = document.querySelectorAll("label")
	for(let i = 0 ; i < inputs.length ; i++){
		let value = inputs[i].value.trim();
		if(!value){
			alert(labels[i].innerText+' 입력이 필요합니다.')
			return			
		}
		if(value.includes(" ")){
			alert(labels[i].innerText+'에 공백을 제거해주세요.')
			return			
		}
		if(i == 3 && !value.match(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/)){
			alert(labels[i].innerText+' 형식이 맞지않습니다.')
			return			
		}
		if(i == 4 && !value.match(/^010-\d{3,4}-\d{4}$/)){
			alert(labels[i].innerText+' 형식이 맞지않습니다.')
			return			
		}
	}
	if(document.querySelector("#insertId").value != checkId){
		alert('아이디 중복체크가 필요합니다.')
		return;
	}
	form.submit()
}

const email = document.querySelector("#insertEmail") 
email.addEventListener("input", () => {
	const span = document.querySelector("#insertEmailSpan");
	if(!email.value.match(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/)){
		email.style.border = "2px solid crimson"
		span.textContent = 'test@example.com 의 형식으로 입력하세요'
		span.style.marginBottom = "0px"
	}else{
		email.style.border = "2px solid royalblue"
		span.textContent = ''
		span.style.marginBottom = "13px"
	}
	
})
const phone = document.querySelector("#insertPhone") 
phone.addEventListener("input", () => {
	const span = document.querySelector("#insertPhoneSpan");
	if(!phone.value.match(/^010-\d{3,4}-\d{4}$/)){
		phone.style.border = "2px solid crimson"
		span.textContent = '010-0000-0000 의 형식으로 입력하세요'
		span.style.marginBottom = "0px"
	}else{
		phone.style.border = "2px solid royalblue"
		span.textContent = ''
		span.style.marginBottom = "13px"
	}
	
})
