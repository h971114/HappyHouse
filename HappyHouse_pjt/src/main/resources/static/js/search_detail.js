$(document).ready(function(){	
	$.get("deal"
			,{code:$("#code").val(), aptName:$('#aptName').val(),dong:$('#dong').val()}
			,function(data, status){
				var aptName = $('#aptName').val();
				var dong = $('#dong').val();
				$("#searchResults").empty();
				$("#searchResults").append("<h5>거래 정보 - "+aptName+"</h5>");
				$.each(data, function(index, vo) {
					let str = "<div class='result'>"
					+ "<div class='resultPrice'>거래금액 : "+vo.dealAmount+"</div>"
					+ "<div class='resultArea'>면적 : "+vo.area+"</div>"

					+ "<div class='resultDate'>"+vo.dealYear+"."+vo.dealMonth+"."+vo.dealDay+"</div>"
					+ "</div>";
					$("#searchResults").append(str);
				});//each
			}//function
			, "json"
	);//get	
});//ready