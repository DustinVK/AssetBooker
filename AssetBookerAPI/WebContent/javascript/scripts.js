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
	    	format: "yyyy-mm-dd",
	    	maxViewMode: 1,
	        startDate: "yesterday",
	        daysOfWeekDisabled: "0,6",
	        daysOfWeekHighlighted: "1,2,3,4,5",
	        todayHighlight: true,
	        //datesDisabled: ['04/06/2021', '04/21/2021'],
   		 });
   		 
   		 $('#datePicker').datepicker().on('changeDate', function (ev) {
    		$('#outDate').val(ev.format());
		});
		

		showReservationForm(tag);
		
	} else if(view=='reservations'){
		listReservations();
	} else if(view=='reservation'){
		resID  = getQueryStringVariable('id');
		modifyReservationForm(resID);
	}

});

var getQueryStringVariable = function ( field, url ) {
		var href = url ? url : window.location.href;
		var reg = new RegExp( '[?&]' + field + '=([^&#]*)', 'i' );
		var string = reg.exec(href);
		return string ? string[1] : null;
	};
	

function listAssets(){
	
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
			
			if($("#postFooter").text()){
				document.getElementById('postFooter').innerHTML += lstResults;
			}
    		
    	});
	});
}



	