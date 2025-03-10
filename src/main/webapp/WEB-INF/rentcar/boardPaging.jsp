<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<c:if test="${ (category == 1 || log eq null) && (category != 1 || log != 1) }">
	<h1>${ category == 1 ? '공지사항' : category == 2 ? '이용후기' : '문의사항' }</h1>
</c:if>
<div class="board-list-box">
	<c:if test="${ (category != 1 && log ne null) || (category == 1 && log == 1) }">
		<div class="board-btn-box">
			<div class="board-list-blank"></div>
			<h1>${ category == 1 ? '공지사항' : category == 2 ? '이용후기' : '문의사항' }</h1>
			<button class="btn-add-board" onclick="location.href='${ctx}/boardInsert.do'">글쓰기</button>
		</div>
	</c:if>
	<div class="board-box">
		<div class="board-list">
			<table class="list-table">
				<tr>
					<th>번호</th>
					<th class="board-title-width">제목</th>
					<th class="board-id-width">작성자</th>
					<th>작성일</th>
				</tr>
				<tr><td class="hr-td" colspan="11"><hr></td></tr>
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td>${ board.board_num }</td>
						<td class="board-title-width"><a href="boardContent.do?num=${ board.board_num }">${ board.title }</a></td>
						<td class="board-id-width">${ board.userid }</td>
						<td>${ board.datetime.substring(0, board.datetime.indexOf(" ")) }</td>
					</tr>
					<tr><td class="hr-td" colspan="11"><hr class="dot-hr"></td></tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="board-page-btn">
		<c:if test="${ minpage > 5 }">
			<button class="btn-before" onclick="location.href='${ctx}/boardPaging.do?category=${ category }&curpage=${ minpage - 5 }'"><</button>
		</c:if>
		<c:forEach var="i" begin="${ minpage }" end="${ (minpage + 4) > lastpage ? lastpage : (minpage + 4) }">
			<c:choose>
				<c:when test="${ i == curpage }">
					<button class="btn-page on" onclick="location.href='${ctx}/boardPaging.do?category=${ category }&curpage=${ i }'">${ i }</button>
				</c:when>
				<c:otherwise>
					<button class="btn-page" onclick="location.href='${ctx}/boardPaging.do?category=${ category }&curpage=${ i }'">${ i }</button>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${ (minpage + 4) < lastpage }">
			<button class="btn-after" onclick="location.href='${ctx}/boardPaging.do?category=${ category }&curpage=${ minpage + 5 }'">></button>
		</c:if>
	</div>
</div>

<%@ include file="../../part/footer.jsp" %>