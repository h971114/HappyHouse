<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:set value="${pageContext.request.contextPath}" var="root"/> 
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>HappyHouse</title>

  <!-- Bootstrap core CSS -->
  <link href="${root }/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="${root }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="${root }/resources/css/clean-blog.min.css" rel="stylesheet">

  	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
  
  <!-- jQuery Modal -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
  
    <style type="text/css">
	#map{
		width: 100%; height: 300px; margin: auto;
	}
	aside{
		font-size: 20px;
		padding : 10px;
	}
	aside span{
		font-weight: bold;
	}
	aside div{
		margin: 10px;
	}
  </style>
</head>

<body>

 	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav" style="background-color:"#FFFFFF" >
		<div class="container">
			<a class="navbar-brand" href="${root}/index" style="color:#283B42">Happy House</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
						<a class="nav-link"	href="../notice?act=list&pg=1" style="color:#283B42">공지사항</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="${root}/news/news_list" style="color:#283B42">부동산 뉴스</a>
					</li>
					<c:if test="${empty login }">
						<li class="nav-item"><a class="nav-link"
							href="member/loginmodal" rel="modal:open" style="color:#283B42">로그인</a></li>
					</c:if>
					<c:if test="${not empty login }">
						<li class="nav-item"><a class="nav-link" href="../member/myPage" style="color:#283B42">마이페이지</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="../member/logout" style="color:#283B42">로그아웃</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Header -->
	<header class="masthead"
		style="background-color: #FAFAFA">
		<div class="overlay" style="background-color:#85B8CB"></div>
		<div class="container" style="height: 550px">
			<div class="row">
			
				<div class="col-lg-17 col-md-12 mx-auto">
					<div class="site-heading">
						<p style="font-size:1.8em; color:#1D6A96; margin=50px"><b>당신이  <span style="color:#283B42; font-size:2.0em;"><b> 살고싶은 곳 </b></span>  은 어디인가요?</b></p>
	
					</div>
			
				</div>
			</div>
		
		</div>
	</header>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-16 mx-auto">
				<div class="search-header">
					<h3 class="search-title text-secondary">
						<strong>회원정보</strong>
					</h3>
					<hr>
				</div>
				<form name="sentmodify" id="contactForm" novalidate>
					<div class="control-group">
						<div class="form-group floating-label-form-group controls">
							<label>ID</label> <input type="text" class="form-control"
<%-- 								placeholder="<%=member.getId() %>" id="id" required --%>
								placeholder="${login }" id="id" required
								data-validation-required-message="Please enter your ID."
								readonly>
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="control-group">
						<div class="form-group floating-label-form-group controls">
							<label>Password</label> <input type="Password"
								class="form-control" placeholder="Password" id="password"
								required
								data-validation-required-message="Please enter your Password."
								readonly>
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Name</label> <input type="text" class="form-control"
								placeholder="${member.getName()}" id="name" required
								data-validation-required-message="Please enter your Name."
								readonly>
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="control-group">
						<div class="form-group floating-label-form-group controls">
							<label>address</label><input type="text" class="form-control"
								placeholder="${member.getAddress()}" id="address" required
								data-validation-required-message="Please enter your Address."
								readonly>
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="control-group">
						<div class="form-group floating-label-form-group controls">
							<label>Phone Number</label><input type="text"
								class="form-control" placeholder="${member.getPhoneNumber()}" id="phonenumber"
								required
								data-validation-required-message="Please enter your Phone Number."
								readonly>
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="control-group">
						<div class="form-group floating-label-form-group controls">
							<label>Interest Area</label><input type="text" name="interestArea" class="form-control"
								placeholder="${intArea }" id="interestArea" readonly>
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<br>
					<div align="right">
						<div class="modify-footer">
							<button type="button" id="modify_btn" class="btn btn-primary"
								onClick="location.href='${root}/member/modify'">modify</button>
							<button type="button" id="delete_btn" class="btn btn-danger"
								onClick="location.href='${root}/member/remove'">delete</button>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>

	<hr>
	
	<!-- Footer -->
  <footer>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <ul class="list-inline text-center">
            <li class="list-inline-item">
              <a href="https://lab.ssafy.com/plp5657/happyhousebackend">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
          </ul>
          <p class="copyright text-muted">Copyright &copy; HappyHouse 2020</p>
        </div>
      </div>
    </div>
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="${root }/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${root }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="${root }/resources/js/clean-blog.min.js"></script>
  
  <script src="${root }/resources/js/index.js"></script>

</body>
