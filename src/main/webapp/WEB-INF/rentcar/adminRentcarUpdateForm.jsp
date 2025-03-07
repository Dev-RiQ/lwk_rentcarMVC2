<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<h1>차량정보수정</h1>
<div class="car-update-box">
	<form class="car-update-form" action="${ ctx }/rentcarUpdate.do?check=1" method="post" enctype="multipart/form-data">
		<div class="car-update-sec">
			<div class="car-update-input">
				<input name="num" id="num" type="hidden" value="${ car.num }" />
				<label for="carName">차량명</label>
				<input name="carName" id="carName" type="text" value="${ car.name }"/>
			</div>
			<div class="car-update-input">
				<label class="update-category" for="carCategory">카테고리</label>
				<label><input name="carCategory" id="carCategory" type="radio" value="1" ${ car.category == 1 ? "checked" : "" }/>소형</label>
				<label><input name="carCategory" id="carCategory" type="radio" value="2" ${ car.category == 2 ? "checked" : "" }/>중형</label>
				<label><input name="carCategory" id="carCategory" type="radio" value="3" ${ car.category == 3 ? "checked" : "" }/>대형</label>
			</div>
			<div class="car-update-input">
				<label for="carPrice">가격</label>
				<input name="carPrice" id="carPrice" type="number" min="1" value="${ car.price }"/>
			</div>
			<div class="car-update-input">
				<label for="carUsepeople">최대 수용 인원</label>
				<input name="carUsepeople" id="carUsepeople" type="number" min="1" value="${ car.usepeople }"/>
			</div>
			<div class="car-update-input">
				<label for="carTotalQty">재고</label>
				<input name="carTotalQty" id="carTotalQty" type="number" min="1" value="${ car.total_qty }"/>
			</div>
			<div class="car-update-input">
				<label for="carCompany">회사</label>
				<input name="carCompany" id="carCompany" type="text" value="${ car.company }"/>
			</div>
			<div class="car-update-input">
				<label for="carInfo">차량정보</label>
				<textarea name="carInfo" id="carInfo">${ car.info }</textarea>
			</div>
			<div class="car-update-input">
				<label for="carImg">이미지</label>
				<input name="carImg" id="carImg" type="file" accept="image/*"/>
			</div>
				<img alt="img.jpg" src="${ctx}/img/${car.img}">
			<div class="car-update-submit">
				<button class="btn-car-update" onclick="reservationInsertValidCheck()">수정하기</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../../part/footer.jsp" %>
<script src="${ctx}/js/rentcarInsert.js"></script>