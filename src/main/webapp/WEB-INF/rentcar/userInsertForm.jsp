<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<h1>회원가입</h1>
<div class="insert-box">
	<form class="insert-form" action="${ ctx }/userInsert.do" method="post">
		<div class="insert-sec">
			<div class="insert-input">
				<label for="insertId">아이디</label>
				<input name="insertId" id="insertId" type="text"/>
				<button class="btn-insert">중복체크</button>
			</div>
			<div class="insert-input">
				<label for="insertPw">비밀번호</label>
				<input name="insertPw" id="insertPw" type="password"/>
			</div>
			<div class="insert-input">
				<label for="insertName">이름</label>
				<input name="insertName" id="insertName" type="text"/>
			</div>
			<div class="insert-input">
				<label for="insertEmail">이메일</label>
				<input name="insertEmail" id="insertEmail" type="text"/>
			</div>
			<div class="insert-input">
				<label for="insertPhone">전화번호</label>
				<input name="insertPhone" id="insertPhone" type="text"/>
			</div>
			<div class="insert-submit">
				<button class="btn-insert">회원가입</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../../part/footer.jsp" %>