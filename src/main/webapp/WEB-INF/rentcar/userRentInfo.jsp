<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<h1>예약현황</h1>
<div class="res-info-box">
	<form class="res-info" action="${ctx}/userRentInfoUpdate.do" method="post">
		<table class="res-info-table">
			<tr>
				<td colspan="2"><img src="${ctx}/img/${ detail.img }" /></td>
			</tr>
			<tr>
				<th>회사</th>
				<td>${ detail.company }</td>
			</tr>
			<tr>
				<th>차량명</th>
				<td>${ detail.name }</td>
			</tr>
			<tr>
				<th>차량가격</th>
				<td id="carPrice">${ detail.price }</td>
			</tr>
			<tr>
				<th>탑승인원</th>
				<td>${ detail.usepeople }</td>
			</tr>
			<tr>
				<th>현재 재고</th>
				<td><span id="totalQty">${ detail.total_qty }</span></td>
			</tr>
			<tr>
				<th>정보</th>
				<td class="car-infotext">${ detail.info }</td>
			</tr>
		</table>
		<table class="res-info-table">
			<tr>
				<td colspan="2"><div class="user-table-blank"></div></td>
			</tr>
			<tr>
				<th>예약번호</th>
				<td>${ detail.reserve_seq }<input name="updateSeq" id="updateSeq" type="hidden" value="${ detail.reserve_seq }" /></td>
			</tr>
			<tr>
				<th>대여시작일</th>
				<td><input name="rentRday" id="rentRday" type="date" value="${ detail.rday }" readonly /></td>
			</tr>
			<tr>
				<th>대여종료일</th>
				<td><input name="rentEday" id="rentEday" type="date" value="${ detail.eday }" min="${ reservation }" /></td>
			</tr>
			<tr>
				<th>대여일</th>
				<td><span id="ddayCalc">${ detail.dday }</span>
				<input name="updateDday" id="updateDday" type="hidden" value="${ detail.dday }" /></td>
			</tr>
			<tr>
				<th>운전자보험</th>
				<td>
					<input name="in" id="in" type="radio" value="1" ${ detail.usein == 1 ? "checked":"" }/> 가입
					<input name="in" id="in" type="radio" value="0" ${ detail.usein == 0 ? "checked":"" } /> 미가입
				</td>
			</tr>
			<tr>
				<th>인터넷</th>
				<td>
					<input name="wifi" id="wifi" type="radio" value="1" ${ detail.usewifi == 1 ? "checked":"" } /> 추가
					<input name="wifi" id="wifi" type="radio" value="0" ${ detail.usewifi == 0 ? "checked":"" } /> 미추가
				</td>
			</tr>
			<tr>
				<th>네비게이션</th>
				<td>
					<input name="navi" id="navi" type="radio" value="1" ${ detail.usenavi == 1 ? "checked":"" } /> 추가
					<input name="navi" id="navi" type="radio" value="0" ${ detail.usenavi == 0 ? "checked":"" } /> 미추가
				</td>
			</tr>
			<tr>
				<th>베이비시트</th>
				<td>
					<input name="seat" id="seat" type="radio" value="1" ${ detail.useseat == 1 ? "checked":"" } /> 추가
					<input name="seat" id="seat" type="radio" value="0" ${ detail.useseat == 0 ? "checked":"" } /> 미추가
				</td>
			</tr>
			<tr>
				<th>수량</th>
				<td><input name="updateQty" id="updateQty" type="number" value="${ detail.qty }" min="1" max="${ detail.qty + detail.total_qty}"/></td>
			</tr>
			<tr><td></td><td>
				<span id="totalQtySpan"></span></td>
			</tr>
			<tr>
				<th>총 금액</th>
				<td id="totalPrice"></td>
			</tr>
			<tr>
				<td><button onclick="reservationInsertValidCheck()">수정하기</button></td>
				<td><button type="button" onclick="location.href='${ctx}/userRentInfoDelete.do?seq=${ detail.reserve_seq }'">삭제하기</button></td>
			</tr>
		</table>
	</form>
</div>

<%@ include file="../../part/footer.jsp" %>
<script src="${ctx}/js/reservationUpdate.js"></script>