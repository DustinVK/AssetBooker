$(document).ready(function(){



	
	view = getQueryStringVariable('view');
	
	if(view == null){
		view = "";
	}
	
	if(view == 'assets') {
		
		listAssets();
		
	} else if(view == 'reserve') {
		tag = getQueryStringVariable('tag');
		
	    $('#datePicker').datepicker({
	        startDate: "yesterday",
	        daysOfWeekDisabled: "0,6",
	        daysOfWeekHighlighted: "1,2,3,4,5",
	        todayHighlight: true,
	        //datesDisabled: ['04/06/2021', '04/21/2021'],
	        defaultViewDate: { year: 1977, month: 04, day: 25 }
   		 });
   		 
   		 $('#datePicker').datepicker().on('changeDate', function (ev) {
    		$('#outDate').val(ev.format());
		});
		

		showReservationForm(tag);
		
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


function requestReservation(){

	var assetTag = $("#assetTag").val();
	var userID = 1;
	var outDate = $("#outDate").val();
	var outTime = $("#outTime").val();
	var checkOut = outDate + " " + outTime;

	console.log("testii");
	
	var parms = { assetTag:assetTag, userID:userID, checkOut:checkOut};
	
	console.log(parms.checkOut);
	
	$.ajax({
		url: "./rest/reservations/",
		type: 'POST',
		dataType : "json",
        contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){
		alert(response.message);
	});
}


function showReservationForm(assetTag){

		//document.getElementById('outDate');
		

		
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
			
			//var calendarLink = "<a class='calendar-link' href='./index.jsp?view=calendar&tag=" + assetTag + "'>Availability Calendar</a>";

       		
			//document.getElementById('calendarBox').innerHTML += calendarLink;
			
			
			
			

		});
	}
	