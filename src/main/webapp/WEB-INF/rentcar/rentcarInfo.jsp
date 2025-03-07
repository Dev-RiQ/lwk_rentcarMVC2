<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<h1>차량 상세 정보</h1>
<div class="car-info-box">
	<div class="info-box">
		<div class="info-detail">
			<form class="rent-select" action="${ctx}/userRentInfoInsert.do" method="post">
				<table class="detail-table">
					<tr>
						<td colspan="2"><img src="${ctx}/img/${ detail.img }" /></td>
					</tr>
					<tr>
						<th>회사</th>
						<td>${ detail.company }</td>
					</tr>
					<tr>
						<th>차량명</th>
						<td>${ detail.name }
						<input name="rentNum" id="rentNum" type="hidden" value="${ num }" />
						<input name="rentId" id="rentId" type="hidden" value="${ userid }" />
						<input name="rentName" id="rentName" type="hidden" value="${ detail.name }" />
						</td>
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
						<th>현재재고</th>
						<td><span id="totalQty">${ detail.total_qty }</span></td>
					</tr>
					<tr>
						<th>정보</th>
						<td>${ detail.info }</td>
					</tr>
				</table>
				<table class="detail-table">
					<tr>
						<td colspan="2"><div class="table-blank"></div></td>
					</tr>
					<tr>
						<th>대여시작일</th>
						<td>
							<input name="rentRday" id="rentRday" type="date" value="${ today }" readonly />
						</td>
					</tr>
					<tr>
						<th>대여종료일</th>
						<td>
							<input name="rentEday" id="rentEday" type="date" value="${reservation}" min="${ reservation }" />
						</td>
					</tr>
					<tr>
						<th>대여일</th>
						<td><span id="ddayCalc">1일</span>
						<input name="rentDday" id="rentDday" type="hidden" value="1" />
						</td>
					</tr>
					<tr>
						<th>운전자보험</th>
						<td>
							<input name="in" id="in" type="radio" value="1"  /> 가입
							<input name="in" id="in" type="radio" value="0" checked /> 미가입
						</td>
					</tr>
					<tr>
						<th>인터넷</th>
						<td>
							<input name="wifi" id="wifi" type="radio" value="1" /> 추가
							<input name="wifi" id="wifi" type="radio" value="0" checked /> 미추가
						</td>
					</tr>
					<tr>
						<th>네비게이션</th>
						<td>
							<input name="navi" id="navi" type="radio" value="1" /> 추가
							<input name="navi" id="navi" type="radio" value="0" checked /> 미추가
						</td>
					</tr>
					<tr>
						<th>베이비시트</th>
						<td>
							<input name="seat" id="seat" type="radio" value="1" /> 추가
							<input name="seat" id="seat" type="radio" value="0" checked /> 미추가
						</td>
					</tr>
					<tr>
						<th>수량</th>
						<td>
							<input name="rentQty" id="rentQty" type="number" value="1" min="1" max="999"/>
							<span id="totalQtySpan"></span>
						</td>
					</tr>
					<tr>
						<th>총 금액</th>
						<td id="totalPrice">${ detail.price }원</td>
					</tr>
					<tr>
						<td colspan="2"><button onclick="reservationInsertValidCheck()">예약신청</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>

<%@ include file="../../part/footer.jsp" %>
<script src="${ctx}/js/reservationInsert.js"></script>