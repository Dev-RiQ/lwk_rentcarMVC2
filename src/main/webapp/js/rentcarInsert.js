const ctx = "/"+ window.location.pathname.split("/")[1];
const form = document.querySelector("form");

form.addEventListener("submit", (e) => {
	e.preventDefault();
})

function reservationInsertValidCheck(){
	const inputs = document.querySelectorAll("input")
	for(let i = 0 ; i < inputs.length - 1 ; i++){
		let value = inputs[i].value.trim();
		if(!value){
			alert('입력되지 않은 값이 있습니다.')
			return			
		}
	}
	if(!document.querySelector("textarea").value.trim()){
		alert('입력되지 않은 값이 있습니다.')
		return			
	}
	form.submit()
}
document.querySelector('#carTotalQty').addEventListener("keydown", (e) => {
	e.preventDefault();
	return false;
})
document.querySelector('#carUsepeople').addEventListener("keydown", (e) => {
	e.preventDefault();
	return false;
})