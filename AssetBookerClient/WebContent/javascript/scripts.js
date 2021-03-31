$(document).ready(function(){
	
	view = getQueryStringVariable('view');
	
	if(view == null){
		view = "";
	}
	
	if(view == 'assets') {
		
		listAssets();
		
	} else if(view == 'reserve') {
		tag = getQueryStringVariable('tag');
		
		reserveAsset(tag);
		
	} 

});

var getQueryStringVariable = function ( field, url ) {
		var href = url ? url : window.location.href;
		var reg = new RegExp( '[?&]' + field + '=([^&#]*)', 'i' );
		var string = reg.exec(href);
		return string ? string[1] : null;
	};
	

function listAssets(){

	console.log("list assets");
	
	$.ajax({
		url: "../AssetBookerAPI/rest/assets/",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	$.each(response, function(key, value) {
	/*
			if(value.articleContent.length > 200) {
				value.articleContent = value.articleContent.substring(0,200) + "...";
			}
    	*/	
    		var lstResults = "<tr>" +
	            "<td>"+value.description+"</td><td>"+value.assetStatusName+"</td><td>"+value.assetTypeName+"</td>"+
	            "<td><a href='./index.jsp?view=reserve&tag=" + value.assetTag + "'>Reserve</a></td>" +
	            "</tr>";

       		if($("#postBody").text()){
				document.getElementById('postBody').innerHTML += lstResults;
			}
    		
    	});
	});
}

function requestReservation() {

}

function reserveAsset(assetTag){
		
		$.ajax({
			url: "../AssetBookerAPI/rest/assets/"+assetTag,
			type: 'GET',
			dataType : "json",
	        contentType: "application/json",
		}).fail(function(response) {
			console.log(JSON.stringify(response));
	
	    }).done(function(response){
	    	
	    	$("#assetTag").val(assetTag);
	    	$("#description").val(response.description);
	    	$("#type").val(response.assetTypeName);
	    	$("#notes").val(response.notes);
			
			var calendarLink = "<a class='calendar-link' href='./index.jsp?view=calendar&tag=" + assetTag + "'>Availability Calendar</a>";

       		
			document.getElementById('calendarBox').innerHTML += calendarLink;
			
			

		});
	}
	