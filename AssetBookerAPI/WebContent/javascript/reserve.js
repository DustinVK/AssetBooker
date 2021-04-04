function requestReservation(){

	var assetTag = $("#assetTag").val();
	var userID = 1;
	var outDate = $("#outDate").val();
	var outTime = $("#outTime").val();
	var checkOut = outDate + " " + outTime;

	var parms = { assetTag:assetTag, userID:userID, checkOut:checkOut};
	
	//console.log(parms.checkOut);
	
	$.ajax({
		url: "./rest/reservations/",
		type: 'POST',
		dataType : "json",
        contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));
		alert("Sorry, something went wrong with your request. Refresh the page and try again or contact an admin for assistance. ");
    }).done(function(response){
		alert(response.message);
		window.location.href = './index.jsp?view=assets';	
		});
	
	
}


function showReservationForm(assetTag){

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
			

		});
}

function modifyReservationForm(resID){

		$.ajax({
			url: "../AssetBookerAPI/rest/reservations/"+resID,
			type: 'GET',
			dataType : "json",
	        contentType: "application/json",
		}).fail(function(response) {
			console.log(JSON.stringify(response));
	
	    }).done(function(response){
	    	
	    	$("#reservationID").val(resID);
	    	$("#checkOut").val(response.checkOut);
	    	$("#status").val(response.status);
	    	$("#assetTag").val(response.assetTag);
			
		});
}

function submitModifyReservationForm(){
	var reservationID = $("#reservationID").val();
	var status = $("#status").val();
	var checkOut = $("#checkOut").val();
	var assetTag = $("#assetTag").val();
	var parms = { reservationID:reservationID, assetTag:assetTag, status:status, checkOut:checkOut};
	
	//console.log(parms.checkOut);
	
	$.ajax({
		url: "../AssetBookerAPI/rest/reservations/"+reservationID,
		type: 'PUT',
		dataType : "json",
        contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));
		alert("Sorry, something went wrong with your request. Refresh the page and try again or contact an admin for assistance. ");
    }).done(function(response){
		alert(response.message);
		window.location.href = './index.jsp?view=assets';	
		});
}

function deleteReservation(resID){
	  if (confirm("Are you sure you want to delete this?")) {
			$.ajax({
			url: "../AssetBookerAPI/rest/reservations/"+resID,
			type: 'DELETE',
			dataType : "json",
	        contentType: "application/json",
		
			}).fail(function(response) {
				alert(response.message);
	    	}).done(function(response){ 
	 			alert(response.message);
	 			location.reload();
			});
  	} 
	
}

function listReservations(){
	
	$.ajax({
		url: "../AssetBookerAPI/rest/reservations/user/1",
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
	            "<td>"+value.description+"</td><td>"+value.name+"</td><td>"+value.checkOut+"</td>"+
	            "<td><a href='./index.jsp?view=reservation&id=" + value.reservationID + "'><i class='fas fa-edit'></i></a></td>" +
	            "<td><button class = 'btn btn-link' type='button' onclick='deleteReservation("+ value.reservationID+")' data-toggle='tooltip' title='Delete'><i class='fas fa-trash'></i></button></td>" +
	            "</tr>";

       		if($("#postBody").text()){
				document.getElementById('postBody').innerHTML += lstResults;
			}
    		
 
    		
    	});
	});
}


