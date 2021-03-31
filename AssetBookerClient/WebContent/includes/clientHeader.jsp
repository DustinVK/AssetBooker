<%
	String view = request.getParameter("view");
%>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>TDMP: Media Checkout</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/simple-sidebar.css" rel="stylesheet">
  
  <link href="css/calendar.css" rel="stylesheet" media="screen">
  
   <link href='css/main.css' rel='stylesheet' />
   <script src='javascript/main.js'></script>
   <script>

     document.addEventListener('DOMContentLoaded', function() {
       var calendarEl = document.getElementById('calendar');
       var calendar = new FullCalendar.Calendar(calendarEl, {
         initialView: 'dayGridMonth'
       });
       calendar.render();
     });

   </script>


</head>