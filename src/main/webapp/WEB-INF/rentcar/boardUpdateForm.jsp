<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<h1>게시글 작성</h1>
<div class="board-update-box">
	<form class="board-update-form" action="${ ctx }/boardUpdate.do?check=1&boardNum=${board.board_num}" method="post" enctype="multipart/form-data">
		<div class="board-update-sec">
			<div class="board-update-input">
				<label for="updateCategory">카테고리</label>
				<select name="updateCategory" id="updateCategory">
					<option value="${ board.category }">${ board.category == 1 ? "공지사항" : board.category == 2 ? "이용후기" : "문의사항" }</option>
				</select>
			</div>
			<c:if test="${ board.category == 2 }">
				<div class="board-update-input">
					<label for="updateNum">이용차량</label>
					<select name="updateNum" id="updateNum">
						<option value="${ board.num }">${ name }</option>
					</select>
				</div>
				<div class="board-update-input">
					<label for="updateScore">평점</label>
					<select name="updateScore" id="updateScore">
						<c:forEach var="i" begin="1" end="5">
							<c:choose>
								<c:when test="${ board.score == 6 - i }">
									<option value="${ 6 - i }" selected>${ 6 - i }점</option>
								</c:when>
								<c:otherwise>
									<option value="${ 6 - i }">${ 6 - i }점</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</c:if>
			<div class="board-update-input">
				<label for="updateTitle">제목</label>
				<input name="updateTitle" id="updateTitle" type="text" value="${ board.title }" />
			</div>
			<div class="board-update-input">
				<label for="updateContent">내용</label>
				<textarea name="updateContent" id="updateContent">${ board.content }</textarea>
			</div>
			<div class="board-update-input">
				<label for="updateImg">이미지</label>
				<input name="updateImg" id="updateImg" type="file" accept="image/*"/>
			</div>
			<c:if test="${ board.img ne '' && board.img ne null }">
				<img src="${ctx}/img/${board.img}" alt="image.img" />
			</c:if>
			<div class="board-update-submit">
				<button class="btn-update" onclick="boardUpdateValidCheck()">등록</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../../part/footer.jsp" %>
<script src="${ctx}/js/boardUpdate.js"></script>