$(document).ready(function(){
	$.get("map"
			,{act:"sido"}
			,function(data, status){
				$.each(data, function(index, vo) {
					$("#sido").append("<option value='"+vo.sido_code+"'>"+vo.sido_name+"</option>");
				});//each
			}//function
			, "json"
		);//get
	});//ready
	$(document).ready(function(){
		$("#sido").change(function() {
			$.get("map"
					,{act:"gugun", sido:$("#sido").val()}
					,function(data, status){
						$("#gugun").empty();
						$("#gugun").append('<option value="0">선택</option>');
						$.each(data, function(index, vo) {
							$("#gugun").append("<option value='"+vo.gugun_code+"'>"+vo.gugun_name+"</option>");
						});//each
					}//function
					, "json"
			);//get
		});//change
		$("#gugun").change(function() {
			$.get("map"
					,{act:"dong", gugun:$("#gugun").val()}
					,function(data, status){
						$("#dong").empty();
						$("#dong").append('<option value="0">선택</option>');
						$.each(data, function(index, vo) {
							$("#dong").append("<option value='"+vo.dong+"'>"+vo.dong+"</option>");
						});//each
					}//function
					, "json"
			);//get
		});//change
	$("#srchBtn").click(function() {
		
		$.get("map"
				,{act:"apt", dong:$("#dong").val()}
				,function(data, status){
					$("#searchResults").empty();
					$("#searchResults").append("<h5>거래 정보</h5>");
					$.each(data, function(index, vo) {
						let str = "<div class='result'>"
						+ "<div class='resultName'><a href='search_detail.jsp'>"+vo.aptName+"</a></div>"
						+ "<div class='resultPrice'>거래금액 : "+"</div>"
						+ "<div class='resultArea'>면적 : "+"</div>"
						+ "<div class='resultDate'>2018.11.05 "+"</div>"
						+ "</div>";
						
						$("#searchResults").append(str);
					});//each
					geocode(data);
					//geocode(data);
				}//function
				, "json"
		);//get
	});//onclick	
});//ready
function geocode(jsonData) {
	let idx = 0;
	$.each(jsonData, function(index, vo) {
		let tmpLat;
		let tmpLng;
		$.get("https://maps.googleapis.com/maps/api/geocode/json"
				,{	key:'AIzaSyDI3a4GzdBUw4TRFbkw-C5tmmxvq3AXu6o'
					, address:vo.dong+"+"+vo.aptName+"+"+vo.jibun
				}
				, function(data, status) {
					//alert(data.results[0].geometry.location.lat);
					tmpLat = data.results[0].geometry.location.lat;
					tmpLng = data.results[0].geometry.location.lng;
					$("#lat_"+index).text(tmpLat);
					$("#lng_"+index).text(tmpLng);
					addMarker(tmpLat, tmpLng, vo.aptName);
				}
				, "json"
		);//get
	});//each
}