<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<div class="board-content-box">
	<div class="content-btn-box">
		<div class="board-content-blank"></div>
		<c:if test="${ num == log || log == 1 }">
			<button class="btn-delete-board" onclick="location.href='${ctx}/boardDelete.do?boardNum=${ board.board_num }'">삭제</button>
			<button class="btn-update-board" onclick="location.href='${ctx}/boardUpdate.do?boardNum=${ board.board_num }'">수정</button>
		</c:if>
		<button class="btn-list-board" onclick="history.back()">뒤로</button>
	</div>
	<div class="content-box">
		<div class="board-content">
			<table class="content-table">
				<tr>
					<th>카테고리</th>
					<td>${ board.category == 1 ? "[공지사항]" : board.category == 2 ? "[이용후기]" : "[문의사항]" }</td>
					<th>번호</th>
					<td>${ board.board_num }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td class="board-title" colspan="4">${ board.title }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${ board.userid }</td>
					<th>작성일</th>
					<td>${ board.datetime }</td>
				</tr>
				<c:if test="${ board.score != 0 }">
					<tr>
						<th>이용차량</th>
						<td>${ carName }</td>
						<th>평점</th>
						<td  class="board-score">
							<c:forEach var="i" begin="1" end="5">
								<c:choose>
									<c:when test="${ board.score < i }">
										☆
									</c:when>
									<c:otherwise>
										★
									</c:otherwise>
								</c:choose>
							</c:forEach>
							(${ board.score })
						</td>
					</tr>
				</c:if>
				<c:if test="${ board.img ne '' && board.img ne null}">
					<tr>
						<td colspan="4"><img src="${ctx}/img/${ board.img }" alt="img" /></td>
					</tr>
				</c:if>
				<tr>
					<th colspan="4">내용</th>
				</tr>
				<tr>
					<td class="board-content" colspan="4">${ board.content }</td>
				</tr>
			</table>
		</div>
	</div>
</div>

<%@ include file="../../part/footer.jsp" %>