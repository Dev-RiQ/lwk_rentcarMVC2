<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../part/header.jsp" %>

<h1>회원정보</h1>
<div class="update-box">
	<form class="update-form" action="${ ctx }/userUpdate.do" method="post">
		<div class="update-sec">
			<div class="update-input">
				<label for="updateId">아이디</label>
				<input name="updateId" id="updateId" type="text" value="${ user.userid }" readonly/>
			</div>
			<div class="update-input">
				<label for="updatePw">비밀번호</label>
				<input name="updatePw" id="updatePw" type="password" value="${ user.pwd }" readonly/>
			</div>
			<div class="update-input">
				<label for="updateName">이름</label>
				<input name="updateName" id="updateName" type="text" value="${ user.name }" readonly/>
			</div>
			<div class="update-input">
				<label for="updateEmail">이메일</label>
				<input name="updateEmail" id="updateEmail" type="text" value="${ user.email }"/>
			</div>
			<div class="update-input">
				<label for="updatePhone">전화번호</label>
				<input name="updatePhone" id="updatePhone" type="text" value="${ user.phone }"/>
			</div>
			<div class="update-submit">
				<button class="btn-update">정보수정</button>
				<button type="button" class="btn-delete" onclick="location.href='${ctx}/userDelete.do'">회원탈퇴</button>
			</div>
		</div>
	</form>
</div>

<%@ include file="../../part/footer.jsp" %>