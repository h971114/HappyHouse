<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<c:set value="${pageContext.request.contextPath}" var="root"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HappyHouse</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

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
  
</head>
<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="${root}/index">Happy House</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
				<a class="nav-link"	href="${root }/notice?act=list">공지사항</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="">오늘의 뉴스</a>
			</li>
          <c:if test="${empty login }">
		    <li class="nav-item">
            	<a class="nav-link" href="${root}/member/loginmodal" rel="modal:open">로그인</a>
            </li>
		  </c:if>
		  <c:if test="${not empty login }">
            <li class="nav-item">        
         		<a class="nav-link" href="${root}/member/myPage">마이페이지</a>     	
            </li>
            <li class="nav-item">
          		<a class="nav-link" href="${root}/member/logout">로그아웃</a>
            </li>
		  </c:if>
        </ul>
      </div>
    </div>
  </nav>


  <!-- Page Header -->

  <header class="masthead" style="background-image: url('${root}/resources/img/about-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="site-heading">
            <h1>HAPPY HOUSE</h1>
            <span class="subheading">행복한 우리집</span>
          </div>
        </div>
      </div>
    </div>
  </header>

	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-16 mx-auto">
				<div class="regist-header">
					<h3 class="regist-title text-secondary">
						<strong>회원가입</strong>
					</h3>
					<hr>
				</div>
				<form name="sentRegist" id="contactForm" method="post" action="${root}/member/regist" novalidate>
					<input type="hidden" name="act" value="regist">
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
								<label>Password</label> <input type="Password" name="password"
									class="form-control" placeholder="Password" id="password"
									required
									data-validation-required-message="Please enter your Password.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div class="form-group col-xs-12 floating-label-form-group controls">
								<label>Name</label> <input type="text" name="name" class="form-control"
									placeholder="Name" id="name" required
									data-validation-required-message="Please enter your Name.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div class="form-group floating-label-form-group controls">
								<label>address</label><input type="text" name="address" class="form-control"
									placeholder="Address" id="address" required
									data-validation-required-message="Please enter your Address.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div class="form-group floating-label-form-group controls">
								<label>Phone Number</label><input type="text" name="phoneNumber" class="form-control"
									placeholder="Phone Number" id="phoneNumber" required
									data-validation-required-message="Please enter your Phone Number.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<div class="form-group floating-label-form-group controls">
								<label>Interest Area</label><input type="text" name="interestArea" class="form-control"
									placeholder="관심지역 : ex)서울특별시 OO구 OO동 - 띄어쓰기를 반드시 포함해주세요." id="interestArea">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<br>
						<div align="right" class="regist-footer">
							<button id="regist_btn" class="btn btn-success">Regist</button>
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
</html>