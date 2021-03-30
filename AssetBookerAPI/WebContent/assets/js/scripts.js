$(document).ready(function(){


	//listNavigations();
	
	view = getQueryStringVariable('view');
	
	if(view == 'assets') {
		articleID = getQueryStringVariable('articleID');
		getArticle(articleID);
	} 

});

var getQueryStringVariable = function ( field, url ) {
		var href = url ? url : window.location.href;
		var reg = new RegExp( '[?&]' + field + '=([^&#]*)', 'i' );
		var string = reg.exec(href);
		return string ? string[1] : null;
	};