<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<div class="reservation-box">
	<c:if test="${ rentList ne null }">
		<div class="delete-all">
			<div></div>
			<h1>예약현황</h1>
			<button class="btn-delete-all" onclick="location.href='${ctx}/userRentListDelete.do'">전체삭제</button>
		</div>
	</c:if>
	<table class="reservation-table">
		<tr class="th-row">
			<th>예약번호</th>
			<th>예약차량</th>
			<th>예약수량</th>
			<th class="day-range">예약기간</th>
			<th>운전자보험</th>
			<th>인터넷</th>
			<th>네비게이션</th>
			<th>베이비시트</th>
			<th>예약정보</th>
			<th>삭제하기</th>
		</tr>
		<tr><td class="hr-td" colspan="11"><hr></td></tr>
		<c:choose>
			<c:when test="${ rentList ne null }">
				<c:forEach var="rentinfo" items="${ rentList }">
					<tr>
						<td>${ rentinfo.reserve_seq }</td>
						<td>${ rentinfo.name }</td>
						<td>${ rentinfo.qty }</td>
						<td>${ rentinfo.rday } ~
							${ rentinfo.eday }<br>
							(${ rentinfo.dday }일)</td>
						<td>${ rentinfo.usein eq 0 ? "X" : "O"}</td>
						<td>${ rentinfo.usewifi eq 0 ? "X" : "O"}</td>
						<td>${ rentinfo.usenavi eq 0 ? "X" : "O"}</td>
						<td>${ rentinfo.useseat eq 0 ? "X" : "O"}</td>
						<td><button onclick="location.href='${ctx}/userRentInfo.do?seq=${ rentinfo.reserve_seq }'">상세보기</button></td>
						<td><button onclick="location.href='${ctx}/userRentInfoDelete.do?seq=${ rentinfo.reserve_seq }'">삭제하기</button></td>
					</tr>
					<tr><td class="hr-td" colspan="11"><hr class="dot-hr"></td></tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr><td colspan="10"><h2>데이터 없음</h2></td></tr>
			</c:otherwise>
		</c:choose>
	</table>
</div>

<%@ include file="../../part/footer.jsp" %>