<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<h1>로그인</h1>
<div class="login-box">
	<form class="login-form" action="${ ctx }/userLogin.do" method="post">
		<div class="login-sec">
			<div class="login-input">
				<label for="loginId">아이디</label>
				<input name="loginId" id="loginId" type="text"/>
			</div>
			<div class="login-input">
				<label for="loginPw">비밀번호</label>
				<input name="loginPw" id="loginPw" type="password"/>
			</div>
			<div class="login-submit">
				<button class="btn-login">로그인</button>
			</div>
		</div>
	</form>
</div>

<%@ include file="../../part/footer.jsp" %>