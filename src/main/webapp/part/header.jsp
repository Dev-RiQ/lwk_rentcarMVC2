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
<link rel="stylesheet" href="${ ctx }/css/rentcar.css">
<link rel="stylesheet" href="${ ctx }/css/user.css">
<link rel="stylesheet" href="${ ctx }/css/reservation.css">
<link rel="stylesheet" href="${ ctx }/css/board.css">
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
	        <a href="${ ctx }/boardPaging.do?category=1&curpage=1">공지사항</a>
	        <c:choose>
	      		<c:when test="${ log != 1}">
			        <a href="${ ctx }/rentcarList.do?curpage=1">예약하기</a>
			        <a href="${ ctx }/userRentList.do?curpage=1">예약내역</a>
			        <a href="${ ctx }/boardPaging.do?category=2&curpage=1">이용후기</a>
			        <a href="${ ctx }/boardPaging.do?category=3&curpage=1">문의하기</a>
	      		</c:when>
	      		<c:otherwise>
			        <a href="${ ctx }/rentcarManage.do?curpage=1">차량관리</a>
			        <a href="${ ctx }/userManage.do?curpage=1">고객관리</a>
			        <a href="${ ctx }/reservationManage.do?curpage=1">예약관리</a>
			        <a href="${ ctx }/boardManage.do?curpage=1">게시글관리</a>
	      		</c:otherwise>
	      	</c:choose>
	      </div>
	    </div>
	  </div>
	</header>
	<section>
	<main>