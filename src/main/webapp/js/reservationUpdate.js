const ctx = "/"+ window.location.pathname.split("/")[1];
const form = document.querySelector("form");

form.addEventListener("submit", (e) => {
	e.preventDefault();
})

function reservationInsertValidCheck(){
	const inputs = document.querySelectorAll("input")
	for(let i = 0 ; i < inputs.length ; i++){
		let value = inputs[i].value.trim();
		if(!value){
			alert('입력되지 않은 값이 있습니다.')
			return			
		}
	}
	form.submit()
}

const qty = document.querySelector("#updateQty") 
let totalQty = parseInt(document.querySelector("#totalQty").innerText) + parseInt(qty.value)
qty.addEventListener("input", () => {
	if(qty.value > totalQty){
		qty.style.border = "2px solid crimson"
		document.querySelector("#totalQtySpan").textContent = '재고를 초과하였습니다.'
	}else{
		qty.style.border = "2px solid royalblue"
		document.querySelector("#totalQtySpan").textContent = ''
		calcTotalPrice();
	}
})
qty.addEventListener("keydown", (e) => {
	e.preventDefault();
	return false;
})
document.querySelector('#rentEday').addEventListener("keydown", (e) => {
	e.preventDefault();
	return false;
})

const rentRday = document.querySelector("#rentRday") 
const rentEday = document.querySelector("#rentEday") 
rentEday.addEventListener("input", () => {
	let time = new Date(rentEday.value).getTime() - new Date(rentRday.value).getTime()
	let diff = time / (1000 * 60 * 60 * 24)
	document.querySelector("#ddayCalc").innerText = diff
	document.querySelector("#updateDday").value = diff
	calcTotalPrice();
})

let userIn = 0;
document.querySelectorAll("#in").forEach((i) => {
	i.addEventListener("input", (e) => {
		userIn = e.target.value
		calcTotalPrice()
	})
})
let wifi = 0;
document.querySelectorAll("#wifi").forEach((i) => {
	i.addEventListener("input", (e) => {
		wifi = e.target.value
		calcTotalPrice()
	})
})
let navi = 0;
document.querySelectorAll("#navi").forEach((i) => {
	i.addEventListener("input", (e) => {
		navi = e.target.value
		calcTotalPrice()
	})
})
let seat = 0;
document.querySelectorAll("#seat").forEach((i) => {
	i.addEventListener("input", (e) => {
		seat = e.target.value
		calcTotalPrice()
	})
})

function calcTotalPrice(){
	let cnt = document.querySelector("#updateQty").value;
	let carPrice = parseInt(document.querySelector("#carPrice").innerText);
	let dday = parseInt(document.querySelector("#ddayCalc").innerText);
	let totalPrice = cnt * ((carPrice + userIn * 10000) * dday + wifi  * 3000 + navi * 5000 + seat * 5000);
	document.querySelector("#totalPrice").innerText = totalPrice+"원"
}

calcTotalPrice();