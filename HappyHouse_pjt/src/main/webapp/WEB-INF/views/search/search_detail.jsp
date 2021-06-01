<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

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
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/clean-blog.min.css" rel="stylesheet">
  
  <!-- jQuery -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
  
  <!-- jQuery Modal -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
  
  <!-- searchXX.html 공통 css -->
  <link href="${pageContext.request.contextPath}/resources/css/search_common.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" 	id="mainNav" style="background-color:"#FFFFFF" >
    <div class="container">
      <a class="navbar-brand" href="${root}/ssafy/index" style="color:#283B42">Happy House</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
       <ul class="navbar-nav ml-auto">
					<li class="nav-item">
						<a class="nav-link"	href="notice?act=list&pg=1" style="color:#283B42">공지사항</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="${root }/ssafy/news/news_list" style="color:#283B42">부동산 뉴스</a>
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
  <header class="masthead" style="background-color: #FAFAFA">
    <div class="overlay" style="background-color:#85B8CB"></div>
    <div class="container">
      <div class="row">
      </div>
      <div class="row searchHouses">
		<div class="col-lg-17 col-md-10 mx-auto" >
			<form class="form-inline justify-content-center"  action="search" 
						method="POST">
				<select id="sido" name="sido" class="form-control mb-2 mr-sm-2" style="height: 40px; width: 250px">
					<option>도/광역시</option>
				</select>
				<select id="gugun" name="gugun" class="form-control mb-2 mr-sm-2 " style="height: 40px; width: 200px">
					<option>시/구/군</option>
				</select>
				<select id="dong" name="dong" class="form-control mb-2 mr-sm-2"style="height: 40px; width: 150px">
					<option>동</option>
				</select>
				<button  class="btn-primary form-control mb-2 mr-ms-2"style="height: 40px; width: 130px; background-color:#283B42">검색</button>
			</form>
		</div>
	  </div>
    </div>
  </header>

  <!-- Main Content -->
  <div class="container">
	  <div class="row">
	  
	  	<div id="searchResults">
	  		<h5>거래 정보 - </h5>
	  		<input id="code" type="hidden" value="${param.code}">
	  		<input id="aptName" type="hidden" value="${param.aptName}">
	  		<input id="dong" type="hidden" value="${param.dong}">
	  		<c:forEach items="${list}" var="house">
	  			<div class="result">
		  			<div class="resultPrice">${house.dealAmount}</div>
		  			<div class="resultArea">${house.area}</div>
		  			<div class="resultDate">${house.dealYear}+"."+${house.dealMonth}+"."+${house.dealDay}</div>
		  		</div>
	  		</c:forEach>
	  	</div>
	 
	    <div id="map"></div>
	    	<button id="storesearch"class="btn-primary form-control mb-2 mr-ms-2" >주변 편의 시설</button>
	    	<script type="text/javascript">
			$(document).ready(function(){
				$('#storesearch').click(function(){
					//location.href = "writeform";
					location.href = "storemodal?dong="+"${param.dong}" + "&pg=1";
				})
			})
		</script>
	    <script src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
			<script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAcQC4jooYFnjhc5TStP2NDZLaZaiMgZHk&callback=initMap"></script>
			<script>
				var multi = {lat: 37.5012743, lng: 127.039585};
				var map;
				var markers = [];
				var infoWindow;
				
				function initMap() {
					map = new google.maps.Map(document.getElementById('map'), {
						center: multi, zoom: 15
					});
					
					infoWindow = new google.maps.InfoWindow;
					
					
					
					
					//멀티캠퍼스
					//const multimarker = new google.maps.Marker({coords: multi, content: '멀티캠퍼스', iconImage: myposition});
					var multimarker = {
							coords: multi,
							iconImage: myposition,
							content: '멀티캠퍼스(역삼)'
					};
					addMarker(multimarker);
					infoWindow.setPosition(multi);
					infoWindow.setContent('멀티캠퍼스.');
					infoWindow.open(map);
				}
				
					
					// Geolocation
					infoWindow = new google.maps.InfoWindow;
					if (navigator.geolocation) {
						navigator.geolocation.getCurrentPosition(function(position) {
							var pos = {
								lat: position.coords.latitude,
								lng: position.coords.longitude
							};
							
							var mymarker = {
									coords: pos,
									iconImage: myposition,
									content: '현재위치'
							};
							addMarker(mymarker);
							
							infoWindow.setPosition(pos);
							infoWindow.setContent('현재 나의 위치.');
							infoWindow.open(map);
							map.setCenter(pos);
						}, function() {
							handleLocationError(true, infoWindow, map.getCenter());
						});
					} else {
						handleLocationError(false, infoWindow, map.getCenter());
					}
				
				
				function handleLocationError(browserHasGeolocation, infoWindow, pos) {
					infoWindow.setPosition(pos);
					infoWindow.setContent(browserHasGeolocation ?
						'Error: Geolocation 서비스 실패.' :
						'Error: Geolocation을 지원하지 않는 브라우저.');
					infoWindow.open(map);
				}
				
				function addMarker(props) {
					const marker = new google.maps.Marker({
						position: new google.maps.LatLng(parseFloat(props.coords.lat),parseFloat(props.coords.lng)),
						map: map
					});
					map.setCenter(marker.getPosition());
					map.setZoom(15);
					
					if(props.iconImage){
						marker.setIcon(props.iconImage);
					}
		
					if(props.content){
						infoWindow = new google.maps.InfoWindow({
							content:props.content
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
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="${pageContext.request.contextPath}/resources/js/clean-blog.min.js"></script>
  
  <script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/search_detail.js"></script>

</body>

</html>
