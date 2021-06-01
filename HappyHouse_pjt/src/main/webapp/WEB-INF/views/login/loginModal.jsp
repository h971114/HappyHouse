<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="root"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="../css/clean-blog.min.css" rel="stylesheet">

</head>
<body >
	<div class="container" >
		<div class="row">
			<div class="col-lg-12 col-md-16 mx-auto">
				<div class="login-header">
					<h3 class="login-title text-secondary">
						<strong>로그인</strong>
					</h3>
					<hr>
				</div>
				<form name="sentRegist" id="contactForm" method="post" action="${root}/member/login" novalidate>
<!-- 					<input type="hidden" name="act" value="logincheck"> -->
					<div class="control-group">
						<div class="form-group floating-label-form-group controls">
							<label>ID</label> <input type="text" name="id" class="form-control"
								placeholder="ID" id="id" required
								data-validation-required-message="Please enter your ID.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="control-group">
						<div class="form-group floating-label-form-group controls">
							<label>Password</label> <input type="Password" name="pw"
								class="form-control" placeholder="Password" id="pw"
								required
								data-validation-required-message="Please enter your Password.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<br>
					<div align="right" class="login-footer">
						<button type="submit" id="login_btn" class="btn btn-warning">Login</button>
<%-- 						<button type="submit" formaction="${root}/member/regist" id="regist_btn" class="btn btn-success">Regist</button> --%>
						<button type="button" id="regist_btn" class="btn btn-success"
								onClick="location.href='${root}/member/regist'">Regist</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>