<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<h1>차량추가</h1>
<div class="car-insert-box">
	<form class="car-insert-form" action="${ ctx }/rentcarInsert.do?check=1" method="post" enctype="multipart/form-data">
		<div class="car-insert-sec">
			<div class="car-insert-input">
				<label for="carName">차량명</label>
				<input name="carName" id="carName" type="text"/>
			</div>
			<div class="car-insert-input">
				<label class="insert-category" for="carCategory">카테고리</label>
				<label><input name="carCategory" id="carCategory" type="radio" value="1" checked/>소형</label>
				<label><input name="carCategory" id="carCategory" type="radio" value="2" />중형</label>
				<label><input name="carCategory" id="carCategory" type="radio" value="3" />대형</label>
			</div>
			<div class="car-insert-input">
				<label for="carPrice">가격</label>
				<input name="carPrice" id="carPrice" type="number" min="1" value="10000"/>
			</div>
			<div class="car-insert-input">
				<label for="carUsepeople">최대 수용 인원</label>
				<input name="carUsepeople" id="carUsepeople" type="number" min="1" value="5"/>
			</div>
			<div class="car-insert-input">
				<label for="carTotalQty">재고</label>
				<input name="carTotalQty" id="carTotalQty" type="number" min="1" value="5"/>
			</div>
			<div class="car-insert-input">
				<label for="carCompany">회사</label>
				<input name="carCompany" id="carCompany" type="text"/>
			</div>
			<div class="car-insert-input">
				<label for="carInfo">차량정보</label>
				<textarea name="carInfo" id="carInfo"></textarea>
			</div>
			<div class="car-insert-input">
				<label for="carImg">이미지</label>
				<input name="carImg" id="carImg" type="file" accept="image/*"/>
			</div>
				<img alt="img.jpg" src="${ctx}/img/${img}">
			<div class="car-insert-submit">
				<button class="btn-car-insert" onclick="reservationInsertValidCheck()">등록하기</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../../part/footer.jsp" %>
<script src="${ctx}/js/rentcarInsert.js"></script>