const form = document.querySelector("form");

form.addEventListener("submit", (e) => {
	e.preventDefault();
})

function boardUpdateValidCheck(){
	const inputs = document.querySelectorAll("input")
	if(!inputs[0].value.trim() || !document.querySelector("textarea").value.trim()){
		alert('입력되지 않은 값이 있습니다.')
		return			
	}
	form.submit()
}

const title = document.querySelector("#updateTitle")
let maxTitleLength = 50;
title.addEventListener("input", () => {
	if(title.value.length > maxTitleLength){
		title.value = title.value.substr(0,maxTitleLength)
		alert(`최대 ${maxTitleLength}자까지 입력 가능합니다.`)
	}
})

const content = document.querySelector("#updateContent")
let maxContentLength = 500;
content.addEventListener("input", () => {
	if(content.value.length > maxContentLength){
		content.value = content.value.substr(0,maxContentLength)
		alert(`최대 ${maxContentLength}자까지 입력 가능합니다.`)
	}
})