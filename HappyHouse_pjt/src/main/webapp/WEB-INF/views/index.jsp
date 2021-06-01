<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="root" />
<%@ page import="com.ssafy.happyhouse.model.MemberDto"%>
<%@ page import="com.ssafy.happyhouse.model.dao.MemberDaoImpl"%>
<%@ page import="com.ssafy.happyhouse.model.dao.MemberDao"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>HappyHouse</title>

<!-- Bootstrap core CSS -->
<link href="${root }/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="${root }/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="${root }/resources/css/clean-blog.min.css" rel="stylesheet">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>

<!-- jQuery Modal -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />

<style type="text/css">
#map {
	width: 100%;
	height: 300px;
	margin: auto;
}

aside {
	font-size: 20px;
	padding: 10px;
}

aside span {
	font-weight: bold;
}

aside div {
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
						<a class="nav-link"	href="notice?act=list&pg=1" style="color:#283B42">공지사항</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="${local }/ssafy/news/news_list" style="color:#283B42">부동산 뉴스</a>
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
									<div class="row searchHouses">
				<div class="mx-auto">
					<form class="form-inline justify-content-center" action="search" 
						method="POST">
						
						<select id="sido" name="sido" class="form-control mb-2 mr-sm-2" style="height: 40px; width: 250px">
							<option>도/광역시</option>
						</select> <select id="gugun" name="gugun"
							class="form-control mb-2 mr-sm-2 "style="height: 40px; width: 200px">
							<option>시/구/군</option>
						</select> <select id="dong" name="dong" class="form-control mb-2 mr-sm-2" style="height: 40px; width: 150px">
							<option>동</option>
						</select>
						 <input type="hidden" name="dong" id="dong" value="${dong}" >
						<button class="btn-primary form-control mb-2 mr-ms-2" style="height: 40px; width: 130px; background-color:#283B42">검색</button>
					</form>
				</div>
			</div>
					</div>
			
				</div>
			</div>
		
		</div>
	</header>
	<!-- Main Content -->
	<main id="main">
	<div class="container">

		<div style="width : 400px; float:left;">
			<aside>
			      <table class="table" style="width:380px; float:left; ">
			      <br/>
         <a href="list"><h5><img src="https://img.icons8.com/color/48/000000/star--v1.png"/>  최근 공지사항 </h5></a>
         <tbody id="notice"></tbody>
      </table>
			</aside>	
		</div>
		<div style="width : 700px; float:left;">
			<aside>
			<table class="table" style="width:600px; float:left;">
         <h5><img src="https://img.icons8.com/wired/64/000000/google-news.png"/>    오늘의 뉴스</h5>

         <tbody>
            <c:forEach var="newsTitle" items="${news }" varStatus="status">
               <tr>
                  <td style="width:80%">
                     <li><a href="${newsTitle.getNewsLink() }" target="_blank">${newsTitle.getNewsTitle() }</a></li>
                  </td>
               </tr>
            </c:forEach>
         </tbody>
      </table>
		</aside>
		</div>
	
		<br/>

		<c:if test="${not empty login }">
			<c:if test="${not empty t_per }">
			<div align="center"><img src="https://img.icons8.com/material-outlined/24/000000/quote-left.png"/>  <font size="5em" color="green"><b><c:out value="${login}"/></b></font>  <img src="https://img.icons8.com/material-outlined/24/000000/quote-right.png"/>   님의 관심지역의 특목고 진학률은 <font color="red"><b><c:out value="${t_per}" />%</b></font>로 <b><c:out value="${rank}" /></b>위 입니다.</div>
			</c:if>
			<c:if test="${not empty subways }">
			<div align="center">주변 지하철역은 <c:forEach var="subway" items="${subways}"> '<c:out value="${subway.line }"/>-<c:out value="${subway.name }"/>' </c:forEach>입니다.</div>
			</c:if>
			<div id="map"></div>
			<script
				src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
			<!-- <script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAcQC4jooYFnjhc5TStP2NDZLaZaiMgZHk&callback=initMap"></script>-->
			<script defer
				src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCsA65D66yr4FA8gvONRzTDL22k2YLFJKc&callback=initMap"></script>
			<script>
				var lat
				if (lat == null) {

				}
				var multi = {
					lat : parseFloat('${lat}'),
					lng : parseFloat('${lng}'),
				};
				var map;
				var markers = [];
				var infoWindow;
				var loc = '${dongName}';

				if(isNaN(multi.lat)){
					multi.lat = 37.5012743;
					multi.lng = 127.039585;
					loc = '멀티캠퍼스';
				}
				
				function initMap() {
					map = new google.maps.Map(document.getElementById('map'), {
						center : multi,
						zoom : 15
					});

					infoWindow = new google.maps.InfoWindow;

					//const myposition = "resources/img/my_position.png";

					//멀티캠퍼스
					//const multimarker = new google.maps.Marker({coords: multi, content: '멀티캠퍼스', iconImage: myposition});
					var multimarker = {
						coords : multi,
						//iconImage : myposition,
						//content : '멀티캠퍼스(역삼)'
						content : '' + loc
					};
					addMarker(multimarker);
					infoWindow.setPosition(multi);
					//infoWindow.setContent('멀티캠퍼스.');
					infoWindow.setContent('' + loc);
					infoWindow.open(map);
				}

				function addMarker(props) {
					const marker = new google.maps.Marker({
						position : new google.maps.LatLng(
								parseFloat(props.coords.lat),
								parseFloat(props.coords.lng)),
						map : map
					});
					map.setCenter(marker.getPosition());
					map.setZoom(15);

					/*if (props.iconImage) {
						marker.setIcon(props.iconImage);
					}*/

					if (props.content) {
						infoWindow = new google.maps.InfoWindow({
							content : props.content
						});

					}

					marker.addListener('click', function() {
						map.setZoom(17);
						map.setCenter(marker.getPosition());
						bounceMarker(marker);
					});
					markers.push(marker);
					setMapOnAll(map);
				}

				function bounceMarker(marker) {
					if (marker.getAnimation() !== null) {
						marker.setAnimation(null);
					} else {
						marker.setAnimation(google.maps.Animation.BOUNCE);
					}
				}

				function deleteMarkers() {
					clearMarkers();
					markers = [];
				}

				function clearMarkers() {
					setMapOnAll(null);
				}

				function setMapOnAll(map) {
					for (let i = 0; i < markers.length; i++) {
						markers[i].setMap(map);
					}
				}
			</script>
		</c:if>

	</div>
		
	</main>
	<div style="clear:both;"></div>
	<br>
	<hr>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<ul class="list-inline text-center">
						<li class="list-inline-item"><a
							href="https://lab.ssafy.com/plp5657/happyhousebackend"> <span
								class="fa-stack fa-lg"> <i
									class="fas fa-circle fa-stack-2x"></i> <i
									class="fab fa-github fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
					</ul>
					<p class="copyright text-muted">Copyright &copy; HappyHouse
						2020</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="${root }/resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="${root }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="${root }/resources/js/clean-blog.min.js"></script>

	<script src="${root }/resources/js/index.js"></script>

</body>

</html>
