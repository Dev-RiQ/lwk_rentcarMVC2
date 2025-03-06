<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<c:set var="ctx" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lwk_rentcar</title>
<link rel="stylesheet" href="${ ctx }/css/style.css">
</head>
<body>
	<header>
	  <div class="log-back">
	    <div class="log-bar">
	      <div class="btn-box">
	      	<c:choose>
	      		<c:when test="${ log eq null}">
			        <a class="btn-join" href="${ ctx }/userInsert.do">회원가입</a>
			        <a class="btn-login" href="${ ctx }/userLogin.do">로그인</a>
	      		</c:when>
	      		<c:otherwise>
			        <a class="btn-logout" href="${ ctx }/userContent.do">내 정보</a>
			        <a class="btn-logout" href="${ ctx }/userLogout.do">로그아웃</a>
	      		</c:otherwise>
	      	</c:choose>
	      </div>
	    </div>
	  </div>
	  <div class="gnb-back">
	    <div class="gnb">
	      <div class="logo">
	        <a href="${ ctx }/index.jsp"><img class="logo-img" src="${ ctx }/img/logo.png" alt="logo.png"></a>
	      </div>
	      <div class="menu-box">
	        <a href="예약">공지사항</a>
	        <c:choose>
	      		<c:when test="${ log != 1}">
			        <a href="${ ctx }/rentcarList.do">예약하기</a>
			        <a href="${ ctx }/userRentList.do">예약내역</a>
	      		</c:when>
	      		<c:otherwise>
			        <a href="${ ctx }/rentcarManage.do">차량관리</a>
			        <a href="${ ctx }/userManage.do">고객관리</a>
	      		</c:otherwise>
	      	</c:choose>
	        <a href="예약">이용후기</a>
	        <a href="예약">문의하기</a>
	      </div>
	    </div>
	  </div>
	</header>
	<main>