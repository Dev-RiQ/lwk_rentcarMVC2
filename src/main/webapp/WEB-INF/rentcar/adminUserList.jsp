<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<h1>유저목록</h1>
<div class="user-list-box">
	<div class="user-box">
		<div class="user-info">
			<table class="user-info-table">
				<tr class="th-row">
					<th>번호</th>
					<th>이름</th>
					<th>아이디</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>정보수정</th>
					<th>회원삭제</th>
				</tr>
				<tr><td class="hr-td" colspan="11"><hr></td></tr>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td>${ user.num }</td>
						<td>${ user.name }</td>
						<td>${ user.userid }</td>
						<td>${ user.email }</td>
						<td>${ user.phone }</td>
						<td><button onclick="location.href='${ctx}/userContent.do?num=${user.num}'">상세보기</button></td>
						<td><button onclick="location.href='${ctx}/userDelete.do?num=${user.num}'">삭제하기</button></td>
					</tr>
					<tr><td class="hr-td" colspan="11"><hr class="dot-hr"></td></tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="board-page-btn">
		<c:if test="${ minpage > 5 }">
			<button class="btn-before" onclick="location.href='${ctx}/userManage.do?curpage=${ minpage - 5 }'"><</button>
		</c:if>
		<c:forEach var="i" begin="${ minpage }" end="${ (minpage + 4) > lastpage ? lastpage : (minpage + 4) }">
			<c:choose>
				<c:when test="${ i == curpage }">
					<button class="btn-page on" onclick="location.href='${ctx}/userManage.do?curpage=${ i }'">${ i }</button>
				</c:when>
				<c:otherwise>
					<button class="btn-page" onclick="location.href='${ctx}/userManage.do?curpage=${ i }'">${ i }</button>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${ (minpage + 4) < lastpage }">
			<button class="btn-after" onclick="location.href='${ctx}/userManage.do?curpage=${ minpage + 5 }'">></button>
		</c:if>
	</div>
</div>

<%@ include file="../../part/footer.jsp" %>