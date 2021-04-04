<div class="form-group col-xs-12 col-md-6">
	<label for="reservationID">Reservation ID</label>
    <input type="number" class="form-control" id="reservationID" readonly>
</div>

<div class="form-group col-xs-12 col-md-6">
	<label for="assetTag">Asset Tag</label>
    <input type="number" class="form-control" id="assetTag" required>
</div>

<div class="form-group col-xs-12 col-md-6">
	<label for="outDate">Checkout Date</label>
    <input type="Date" class="form-control" id="outDate" required>
</div>

 <div class="form-group col-xs-12 col-md-6">
		<form action="#">
				  <label for="outTime">Checkout Time</label>
				  <select name="outTime" id="outTime">
				    <option value="08:00:00">08:00 AM</option>
					<option value="09:00:00">09:00 AM</option>
					<option value="10:00:00">10:00 AM</option>
					<option value="11:00:00">11:00 AM</option>
					<option value="12:00:00">12:00 PM</option>
					<option value="13:00:00">01:00 PM</option>
					<option value="14:00:00">02:00 PM</option>
					<option value="15:00:00">03:00 PM</option>
					<option value="16:00:00">04:00 PM</option>
				  </select> 
				</form>
</div>

<div class="form-group col-xs-12 col-md-6">
    <span>
        <button class="btn btn-primary" type="submit" onclick="requestReservation()" data-toggle="tooltip" title="Submit">Submit Change</button>
    </span>
    <span>
        <button class = "btn btn-link" type="button" onclick="window.history.back()" data-toggle="tooltip" title="Cancel">Cancel</button>
    </span>
</div>