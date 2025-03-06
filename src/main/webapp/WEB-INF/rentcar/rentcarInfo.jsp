<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<h1>차량 상세 정보</h1>
<div class="car-info-box">
	<div class="info-box">
		<div class="info-img">
			<img src="" alt="" />
		</div>
		<div class="info-detail">
			<form class="rent-select" action="${ctx}/userRentInfoInsert.do" method="post">
				<table class="detail-table">
					<tr>
						<th>차량명</th>
						<td>${ detail.name }
						<input name="rentNum" id="rentNum" type="hidden" value="${ num }" />
						<input name="rentId" id="rentId" type="hidden" value="${ userid }" />
						<input name="rentName" id="rentName" type="hidden" value="${ detail.name }" />
						</td>
					</tr>
					<tr>
						<th>수량</th>
						<td>
							<input name="rentQty" id="rentQty" type="number" value="1" min="1" max="999"/>
						</td>
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
						<td>${ detail.dday }
						<input name="rentDday" id="rentDday" type="hidden" value="1" />
						</td>
					</tr>
					<tr>
						<th>운전자보험</th>
						<td>
							<input name="in" id="in" type="radio" value="1" checked /> 가입
							<input name="in" id="in" type="radio" value="0" /> 미가입
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
						<th>총 금액</th>
						<td>변동주기</td>
					</tr>
					<tr>
						<th>차량카테고리</th>
						<td>${ detail.category }</td>
					</tr>
					<tr>
						<th>차량가격</th>
						<td>${ detail.price }</td>
					</tr>
					<tr>
						<th>탑승인원</th>
						<td>${ detail.usepeople }</td>
					</tr>
					<tr>
						<th>총 수량</th>
						<td>${ detail.total_qty }</td>
					</tr>
					<tr>
						<th>회사</th>
						<td>${ detail.company }</td>
					</tr>
					<tr>
						<th>사진</th>
						<td><img src="${ctx}/img/${ detail.img }" /></td>
					</tr>
					<tr>
						<th>정보</th>
						<td>${ detail.info }</td>
					</tr>
					<tr>
						<td rowspan="2"><button>예약신청</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>

<%@ include file="../../part/footer.jsp" %>