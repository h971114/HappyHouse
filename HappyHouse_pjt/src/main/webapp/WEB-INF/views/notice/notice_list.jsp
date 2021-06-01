<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>HappyHouse</title>

   <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/clean-blog.min.css" rel="stylesheet">

  	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
  
  <!-- jQuery Modal -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
  
  <style type="text/css">

  </style>
</head>
<body>
	<form name="pageform" id="pageform" method="GET" action="">
		<input type="hidden" name="pg" id="pg" value="">

	</form>
  <!-- Navigation -->
  	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav" style="background-color:"#FFFFFF" >
		<div class="container">
			<a class="navbar-brand" href="${root}/ssafy/index" style="color:#283B42">Happy House</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
						<a class="nav-link"	href="notice?act=list&pg=1" style="color:#283B42">공지사항</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="${root}/ssafy/news/news_list" style="color:#283B42">부동산 뉴스</a>
					</li>
					<c:if test="${empty login }">
						<li class="nav-item"><a class="nav-link"
							href="member/loginmodal" rel="modal:open" style="color:#283B42">로그인</a></li>
					</c:if>
					<c:if test="${not empty login }">
						<li class="nav-item"><a class="nav-link" href="member/myPage" style="color:#283B42">마이페이지</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="member/logout" style="color:#283B42">로그아웃</a>
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
		<h3><a href="notice?act=list&pg=1">공지사항</a></h3>
		<c:if test="${login eq 'admin' }">
		<div style="text-align: right; margin:10px 0px;">
			<button id="writeNotice" class="btn btn-primary">글 작성</button>
		</div>
		</c:if>
		<script type="text/javascript">
			$(document).ready(function(){
				$('#writeNotice').click(function(){
					//location.href = "writeform";
					location.href = "write";
				})
				$(".page-item").click(function() {
					$("#pg").val(($(this).attr("data-pg")));
					$("#pageform").attr("action", "${root}/ssafy/notice?act=list&").submit();
					//storemodal?dong="+"${param.dong}"
				});
			})
		</script>
		<table class="table">
			<thead class="thead-light">
				<tr>
					<td style="width:10%">글번호</td>
					<td style="width:80%">제목</td>
					<td style="width:10%">조회수</td>
				</tr>
			</thead>
			<tbody>
			<c:if test="${list.size() != 0}">
			<c:forEach items="${list}" var="notice">
			<tr>
			
				<td style="width:10%">${notice.n_no}</td>
				<td style="width:80%"><a href="notice?act=detail&no=${notice.n_no}">${notice.title}</a></td>
				<td style="width:10%">${notice.hit}</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
		<table align="center"  >
	  	<tr>
	  	<td align="center">
	  	${navigation.navigator}
	  	</td>
	  	</tr>
	  	</table>
	</c:if>
	  <c:if test="${list.size() == 0}">
	  <table class="table table-active">
	    <tbody>
	      <tr class="table-info" align="center">
	        <td>작성된 글이 없습니다.</td>
	      </tr>
	    </tbody>
	  </table>
	  </c:if>
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
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="${pageContext.request.contextPath}/resources/js/clean-blog.min.js"></script>
  
  <!-- <script src="${pageContext.request.contextPath}/resources/js/index.js"></script> -->

</body>

</html>
