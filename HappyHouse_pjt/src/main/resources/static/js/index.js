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
});//ready

$(document).ready(function(){
	   $.get("notice"
	      ,{act:"preview"}
	      ,function(data, status){
	         let str = "";
	         $.each(data, function(index, vo) {
	            if(index >= 5){
	               return;
	            }
	            str +="<tr><td><li>";
	            str +="<a href='notice?act=detail&no="+vo.no+"'>"+vo.title+"</a></td></tr>";   
	            
	         });//each
	         //str +="</td></tr>"
	         $("#notice").append(str);
	      }//function
	      , "json"
	   );//get
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
					tmpLng = data.results[1].geometry.location.lng;
					$("#lat_"+index).text(tmpLat);
					$("#lng_"+index).text(tmpLng);
					addMarker(tmpLat, tmpLng, vo.aptName);
				}
				, "json"
		);//get
	});//each
}
