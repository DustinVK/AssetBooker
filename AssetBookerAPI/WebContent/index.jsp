<!DOCTYPE html>
<html lang="en">
<%@include file=".\includes\clientHeader.jsp" %>


<body>

  <div class="d-flex" id="wrapper">

    <!-- Sidebar -->
	<%@include file=".\includes\clientSideBar.jsp" %>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
	<%@include file=".\includes\clientNavBar.jsp" %>
      
	<%
	if(view == null){
		view = "";
	}

	if(view.equals("assets")){%>
			<%@include file=".\includes\assetlist.jsp"%>
		<%}else if(view.equals("reserve")){ %>
			<%@include file=".\includes\reservationForm.jsp" %>
		<%}else if(view.equals("reservations")){ %>
			<%@include file=".\includes\reservations.jsp" %>
		<%}else if(view.equals("reservation")){ %>
			<%@include file=".\includes\reservationEdit.jsp" %>
		<%}else{%>
			<%@include file=".\includes\dashboard.jsp" %>
	<%}%>
		
    </div>
    <!-- /#page-content-wrapper -->

  </div>
  <!-- /#wrapper -->

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  
  <!--  Custom scripts -->
  <script src="javascript/scripts.js"></script>
  <script src="javascript/reserve.js"></script>
  <script src="javascript/bootstrap-datepicker.js"></script>


  
  

  <!-- Menu Toggle Script -->
  <script>
    $("#menu-toggle").click(function(e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
    });
  </script>

</body>

</html>