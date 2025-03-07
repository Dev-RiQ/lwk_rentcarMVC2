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
	if(category.value == 3){
		inputSection.classList.add("off")
	}else{
		inputSection.classList.remove("off")
	}
})