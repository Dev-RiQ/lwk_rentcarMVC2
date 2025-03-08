const form = document.querySelector("form");

form.addEventListener("submit", (e) => {
	e.preventDefault();
})

function boardInsertValidCheck(){
	const inputs = document.querySelectorAll("input")
	if(!inputs[0].value.trim() || !document.querySelector("textarea").value.trim()){
		alert('입력되지 않은 값이 있습니다.')
		return			
	}
	form.submit()
}

const category = document.querySelector("#insertCategory") 
category.addEventListener("input", () => {
	const inputSection = document.querySelector(".category-2");
	if(category.value == 2){
		inputSection.classList.remove("off")
	}else{
		inputSection.classList.add("off")
	}
})

const title = document.querySelector("#insertTitle")
let maxTitleLength = 50;
title.addEventListener("input", () => {
	if(title.value.length > maxTitleLength){
		title.value = title.value.substr(0,maxTitleLength)
		alert(`최대 ${maxTitleLength}자까지 입력 가능합니다.`)
	}
})

const content = document.querySelector("#insertContent")
let maxContentLength = 500;
content.addEventListener("input", () => {
	if(content.value.length > maxContentLength){
		content.value = content.value.substr(0,maxContentLength)
		alert(`최대 ${maxContentLength}자까지 입력 가능합니다.`)
	}
})