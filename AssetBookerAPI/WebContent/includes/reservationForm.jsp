<div class="form-group col-xs-12 col-md-6">
<h2>Reservation Form</h2>
</div>

<div class="form-group col-xs-12 col-md-6">
<label>Select a date to view availability</label>
    <div id ="datePicker">
    </div>
    <div>  </div>
</div>

<div class="form-group col-xs-12 col-md-6">
    <label for="outDate">Checkout Date</label>
    <input type="Date" class="form-control" id="outDate" readOnly >
   
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
       <label for="assetTag">Asset Tag</label>
       <input type="text" class="form-control" id="assetTag" value="" readonly>
</div>
<div class="form-group col-xs-12 col-md-6">
       <label for="description">Description</label>
       <input type="text" class="form-control" id="description" value="" readonly>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="type">Type</label>
    <input class="form-control" id="type" readonly></input>
</div>
<div class="form-group col-xs-12 col-md-6">
	<label for="notes">Notes</label>
    <input type="text" class="form-control" id="notes" readonly>
</div>

<div class="form-group col-xs-12 col-md-6">
    <span>
        <button class="btn btn-primary" type="submit" onclick="requestReservation()" data-toggle="tooltip" title="Submit">Submit</button>
    </span>
    <span>
        <button class = "btn btn-link" type="button" onclick="window.history.back()" data-toggle="tooltip" title="Cancel">Cancel</button>
    </span>
</div>