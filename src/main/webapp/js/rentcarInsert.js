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

const carname = document.querySelector("#carName")
let maxNameLength = 20;
carname.addEventListener("input", () => {
	if(carname.value.length > maxNameLength){
		carname.value = carname.value.substr(0,maxNameLength)
		alert(`최대 ${maxNameLength}자까지 입력 가능합니다.`)
	}
})

const company = document.querySelector("#carCompany")
let maxCompanyLength = 50;
company.addEventListener("input", () => {
	if(company.value.length > maxCompanyLength){
		company.value = company.value.substr(0,maxCompanyLength)
		alert(`최대 ${maxCompanyLength}자까지 입력 가능합니다.`)
	}
})

const info = document.querySelector("#carInfo")
let maxInfoLength = 500;
info.addEventListener("input", () => {
	if(info.value.length > maxInfoLength){
		info.value = info.value.substr(0,maxInfoLength)
		alert(`최대 ${maxInfoLength}자까지 입력 가능합니다.`)
	}
})