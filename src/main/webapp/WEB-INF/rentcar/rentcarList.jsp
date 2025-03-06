<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<h1>차량목록</h1>
<div class="category-box">
	<div class="category">
		<button class="btn-category ${ category == 0 ? 'on' : '' }" onclick="location.href='${ctx}/rentcarList.do?category=0'">전체</button>
		<button class="btn-category ${ category == 1 ? 'on' : '' }" onclick="location.href='${ctx}/rentcarList.do?category=1'">소형</button>
		<button class="btn-category ${ category == 2 ? 'on' : '' }" onclick="location.href='${ctx}/rentcarList.do?category=2'">중형</button>
		<button class="btn-category ${ category == 3 ? 'on' : '' }" onclick="location.href='${ctx}/rentcarList.do?category=3'">대형</button>
	</div>
</div>
<div class="car-list-box">
	<c:forEach var="car" items="${rentcarList}">
		<div class="car-box">
			<div class="car-img">
				<img src="${ctx}/img/${ car.img }" alt="car.jpg" />
			</div>
			<div class="car-info">
				<table class="info-table">
					<tr>
						<th>회사</th>
						<td>${ car.company }</td>
					</tr>
					<tr>
						<th>차량명</th>
						<td>${ car.name }</td>
					</tr>
					<tr>
						<th>정보</th>
						<td>${ car.info }</td>
					</tr>
					<tr>
						<th>차종</th>
						<td>${ car.category == 1 ? "소형" : car.category == 2 ? "중형" : "대형" }</td>
					</tr>
					<tr>
						<th>가격</th>
						<td>${ car.price }</td>
					</tr>
					<tr>
						<th>최대 탑승 인원</th>
						<td>${ car.usepeople }</td>
					</tr>
					<tr>
						<th>잔여 차량 개수</th>
						<td>${ car.total_qty }</td>
					</tr>
				</table>
			</div>
			<div class="car-btn">
				<button class="btn-reservation" onclick="location.href='${ctx}/rentcarInfo.do?num=${car.num}'">예약하기</button>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="../../part/footer.jsp" %>