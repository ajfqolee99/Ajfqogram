<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajfqogram 로그인</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">

</head>
<body>
	<div id="wrap">
		<!-- <c:import url="/WEB-INF/jsp/include/header.jsp"></c:import>-->
		<section class="contents d-flex justify-content-center my-5">
			<div class="mr-5">
				<img width=400 src="https://cdn.pixabay.com/photo/2016/08/09/17/52/instagram-1581266_640.jpg">
			</div>
			<div>
				<div class="login-box d-flex justify-content-center align-items-center border">
					<div class="w-100 p-3">
						<h2 class="text-center">Ajfqogram</h2>
						<br>
						
						<from id="loginForm">
							<input type="text" id="idInput" class="form-control mt-3" placeholder="아이디">
							<input type="password" id="passwordInput" class="form-control mt-3" placeholder="비밀번호">
							<button type="buttom" class="btn btn-primary btn-block mt-3">로그인</button>
							<hr>
						</from>
						<div class="text-center text-secondary">비밀번호를 잊으셨나요?</div>
					</div>
				</div>
				<div class="mt-4 p-3 d-flex justify-content-center align-items-start border">
					계정이 없으신가요?
					<a href="/user/join-view">가입하기</a>
				</div>
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp"></c:import>
	</div>
	
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
	
	
	
</body>
</html>