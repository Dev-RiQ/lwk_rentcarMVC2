const form = document.querySelector("form");

form.addEventListener("submit", (e) => {
	e.preventDefault();
})

const email = document.querySelector("#updateEmail") 
let maxEmailLength = 30;
email.addEventListener("input", () => {
	const span = document.querySelector("#updateEmailSpan");
	if(!email.value.match(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/)){
		email.style.border = "2px solid crimson"
		span.textContent = 'test@example.com 의 형식으로 입력하세요'
		span.style.marginBottom = "0px"
	}else{
		email.style.border = "2px solid royalblue"
		span.textContent = ''
		span.style.marginBottom = "13px"
	}
	if(email.value.length > maxEmailLength){
		email.value = email.value.substr(0,maxEmailLength)
		alert(`최대 ${maxEmailLength}자까지 입력 가능합니다.`)
	}
	
})

const phone = document.querySelector("#updatePhone")
let maxPhoneLength = 30; 
phone.addEventListener("input", () => {
	const span = document.querySelector("#updatePhoneSpan");
	if(!phone.value.match(/^010-\d{3,4}-\d{4}$/)){
		phone.style.border = "2px solid crimson"
		span.textContent = '010-0000-0000 의 형식으로 입력하세요'
		span.style.marginBottom = "0px"
	}else{
		phone.style.border = "2px solid royalblue"
		span.textContent = ''
		span.style.marginBottom = "13px"
	}
	if(phone.value.length > maxPhoneLength){
		phone.value = phone.value.substr(0,maxPhoneLength)
		alert(`최대 ${maxPhoneLength}자까지 입력 가능합니다.`)
	}
})

function userUpdateValidCheck(){
	if(!email.value.match(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/)){
		alert('이메일 형식이 맞지않습니다.')
		return			
	}
	if(!phone.value.match(/^010-\d{3,4}-\d{4}$/)){
		alert('전화번호 형식이 맞지않습니다.')
		return			
	}
	form.submit()
}