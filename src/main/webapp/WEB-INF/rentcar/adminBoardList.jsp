<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>
<h1>전체 게시글</h1>
<div class="board-AllList-box">
	<div class="AllList-box">
		<div class="board-AllList">
			<table class="AllList-table">
				<tr>
					<th>번호</th>
					<th>카테고리</th>
					<th class="board-title-width">제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
				<tr><td class="hr-td" colspan="11"><hr></td></tr>
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td>${ board.board_num }</td>
						<td>${ board.category == 1 ? "[공지]" : board.category == 2 ? "[후기]" : "[문의]" }</td>
						<td class="board-title-width"><a href="boardContent.do?num=${ board.board_num }">${ board.title }</a></td>
						<td>${ board.userid }</td>
						<td>${ board.datetime.substring(0, board.datetime.indexOf(" ")) }</td>
					</tr>
					<tr><td class="hr-td" colspan="11"><hr class="dot-hr"></td></tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="board-page-btn">
		<c:if test="${ minpage > 5 }">
			<button class="btn-before" onclick="location.href='${ctx}/boardManage.do?curpage=${ minpage - 5 }'"><</button>
		</c:if>
		<c:forEach var="i" begin="${ minpage }" end="${ (minpage + 4) > lastpage ? lastpage : (minpage + 4) }">
			<c:choose>
				<c:when test="${ i == curpage }">
					<button class="btn-page on" onclick="location.href='${ctx}/boardManage.do?curpage=${ i }'">${ i }</button>
				</c:when>
				<c:otherwise>
					<button class="btn-page" onclick="location.href='${ctx}/boardManage.do?curpage=${ i }'">${ i }</button>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${ (minpage + 4) < lastpage }">
			<button class="btn-after" onclick="location.href='${ctx}/boardManage.do?curpage=${ minpage + 5 }'">></button>
		</c:if>
	</div>
</div>

<%@ include file="../../part/footer.jsp" %>