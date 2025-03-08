<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<h1>게시글 작성</h1>
<div class="board-insert-box">
	<form class="board-insert-form" action="${ ctx }/boardInsert.do?check=1" method="post" enctype="multipart/form-data">
		<div class="board-insert-sec">
			<div class="select-box">
				<div class="board-insert-input">
					<label for="insertCategory">카테고리</label>
					<select name="insertCategory" id="insertCategory">
						<c:if test="${ log == 1 }">
							<option value="1">공지사항</option>
						</c:if>
						<c:if test="${ log != 1 }">
							<option value="2">이용후기</option>
							<option value="3">문의사항</option>
						</c:if>
					</select>
				</div>
				<div class="category-2 ${ log == 1 ? 'off' : '' }">
					<div class="board-insert-input">
						<label for="insertNum">이용차량</label>
						<select name="insertNum" id="insertNum">
							<c:forEach var="car" items="${ carList }">
								<option value="${ car.num }">${ car.name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="board-insert-input">
						<label for="insertScore">평점</label>
						<select name="insertScore" id="insertScore">
							<c:forEach var="i" begin="1" end="5">
								<option value="${ 6 - i }">${ 6 - i }점</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="board-insert-input">
				<label for="insertTitle">제목</label>
				<input name="insertTitle" id="insertTitle" type="text"/>
			</div>
			<div class="board-insert-input">
				<label class="content-label" for="insertContent">내용</label>
				<textarea name="insertContent" id="insertContent"></textarea>
			</div>
			<div class="board-insert-input">
				<label for="insertImg">이미지</label>
				<input name="insertImg" id="insertImg" type="file" accept="image/*"/>
			</div>
			<div class="board-insert-submit">
				<button class="btn-insert" onclick="boardInsertValidCheck()">등록</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../../part/footer.jsp" %>
<script src="${ctx}/js/boardInsert.js"></script>