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
