<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<div class="add-car">
	<div></div>
	<h1>차량목록</h1>
	<button class="btn-add-car" onclick="location.href='${ctx}/rentcarInsert.do'">차량추가</button>
</div>
<div class="rentcar-list-box">
	<div class="rentcar-box">
		<div class="rentcar-info">
			<table class="rentcar-info-table">
				<tr class="th-row">
					<th>번호</th>
					<th>이름</th>
					<th>카테고리</th>
					<th>가격</th>
					<th>인원</th>
					<th>재고</th>
					<th>회사</th>
					<th>이미지</th>
					<th>정보</th>
					<th>수정하기</th>
					<th>삭제하기</th>
				</tr>
				<tr><td class="hr-td" colspan="11"><hr></td></tr>
				<c:forEach var="car" items="${rentcarList}">
					<tr>
						<td>${ car.num }</td>
						<td>${ car.name }</td>
						<td>${ car.category == 1 ? "소형" : car.category == 2 ? "중형" : "대형" }</td>
						<td>${ car.price }</td>
						<td>${ car.usepeople }</td>
						<td>${ car.total_qty }</td>
						<td>${ car.company }</td>
						<td><img src="${ctx}/img/${ car.img }" alt="car.img" /></td>
						<td>${ car.info }</td>
						<td><button onclick="location.href='${ctx}/rentcarUpdate.do?num=${car.num}'">수정하기</button></td>
						<td><button onclick="location.href='${ctx}/rentcarDelete.do?num=${car.num}'">삭제하기</button></td>
					</tr>
				<tr><td class="hr-td" colspan="11"><hr class="dot-hr"></td></tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>

<%@ include file="../../part/footer.jsp" %>