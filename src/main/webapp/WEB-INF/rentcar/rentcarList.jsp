<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<h1>차량목록</h1>
<div class="category-box">
	<div class="category">
		<button class="btn-category ${ category == 0 ? 'on' : '' }" onclick="location.href='${ctx}/rentcarList.do?category=0&curpage=1'">전체</button>
		<button class="btn-category ${ category == 1 ? 'on' : '' }" onclick="location.href='${ctx}/rentcarList.do?category=1&curpage=1'">소형</button>
		<button class="btn-category ${ category == 2 ? 'on' : '' }" onclick="location.href='${ctx}/rentcarList.do?category=2&curpage=1'">중형</button>
		<button class="btn-category ${ category == 3 ? 'on' : '' }" onclick="location.href='${ctx}/rentcarList.do?category=3&curpage=1'">대형</button>
	</div>
</div>
<div class="car-list-box">
	<c:forEach var="car" items="${rentcarList}">
		<div class="car-box">
			<div class="car-img">
				<img src="${ctx}/img/${ car.img }" alt="car.jpg" />
			</div>
			<hr class="car-info-hr">
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
						<th>가격</th>
						<td>${ car.price }</td>
					</tr>
				</table>
			</div>
			<div class="car-btn">
				<button class="btn-reservation" onclick="location.href='${ctx}/rentcarInfo.do?num=${car.num}'">예약하기</button>
			</div>
		</div>
	</c:forEach>
</div>
<div class="board-page-btn">
	<c:if test="${ minpage > 5 }">
		<button class="btn-before" onclick="location.href='${ctx}/rentcarList.do?category=${category}&curpage=${ minpage - 5 }'"><</button>
	</c:if>
	<c:forEach var="i" begin="${ minpage }" end="${ (minpage + 4) > lastpage ? lastpage : (minpage + 4) }">
		<c:choose>
			<c:when test="${ i == curpage }">
				<button class="btn-page on" onclick="location.href='${ctx}/rentcarList.do?category=${category}&curpage=${ i }'">${ i }</button>
			</c:when>
			<c:otherwise>
				<button class="btn-page" onclick="location.href='${ctx}/rentcarList.do?category=${category}&curpage=${ i }'">${ i }</button>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${ (minpage + 4) < lastpage }">
		<button class="btn-after" onclick="location.href='${ctx}/rentcarList.do?category=${category}&curpage=${ minpage + 5 }'">></button>
	</c:if>
</div>
<%@ include file="../../part/footer.jsp" %>
