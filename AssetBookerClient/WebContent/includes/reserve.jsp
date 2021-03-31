<div class="form-group col-xs-12 col-md-6">
<h2>Reservation Form</h2>
</div>
<div class="form-group col-xs-12 col-md-6">
    <div id="calendarBox">  <i class="far fa-calendar-alt"></i>  </div>
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
    <label for="checkOutDate">Checkout Date</label>
    <input type="date" class="form-control" id="checkOutDate" required autofocus >
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="checkOutTime">Check-out Time</label>
    <input type="time" class="form-control" id="checkOutTime"  min="08:00" max="18:00" required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="checkInDate">Return Date</label>
    <input type="date" class="form-control" id="checkInDate" autofocus >
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="checkInTime">Return Time</label>
    <input type="time" class="form-control" id="checkInTime"  min="08:00" max="18:00" required>
</div>


<div class="form-group col-xs-12 col-md-6">
    <span>
        <button class="btn btn-primary" type="submit" onclick=requestReservation(); data-toggle="tooltip" title="Submit">Submit</button>
    </span>
    <span>
        <button class = "btn btn-link" type="button" onclick="window.history.back()" data-toggle="tooltip" title="Cancel">Cancel</button>
    </span>
</div>