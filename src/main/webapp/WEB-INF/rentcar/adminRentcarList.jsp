<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<h1>차량목록</h1>
<div class="add-car">
	<button class="btn-add-car" onclick="location.href='${ctx}/rentcarInsert.do'">차량추가</button>
</div>
<div class="rentcar-list-box">
	<div class="rentca-box">
		<div class="rentca-info">
			<table class="rentca-info-table">
				<tr class="th-row">
					<th>차량번호</th>
					<th>이름</th>
					<th>카테고리</th>
					<th>가격</th>
					<th>최대 수용 인원</th>
					<th>가용 재고</th>
					<th>회사</th>
					<th>이미지</th>
					<th>정보</th>
					<th>수정하기</th>
					<th>삭제하기</th>
				</tr>
				<c:forEach var="car" items="${rentcarList}">
					<tr>
						<td>${ car.num }</td>
						<td>${ car.name }</td>
						<td>${ car.category }</td>
						<td>${ car.price }</td>
						<td>${ car.usepeople }</td>
						<td>${ car.total_qty }</td>
						<td>${ car.company }</td>
						<td>${ car.img }</td>
						<td>${ car.info }</td>
						<td><button onclick="location.href='${ctx}/rentcarUpdate.do?num=${car.num}'">수정하기</button></td>
						<td><button onclick="location.href='${ctx}/rentcarDelete.do?num=${car.num}'">삭제하기</button></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>

<%@ include file="../../part/footer.jsp" %>