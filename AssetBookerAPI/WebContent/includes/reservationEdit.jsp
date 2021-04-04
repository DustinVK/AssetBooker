<div class="form-group col-xs-12 col-md-6">
	<label for="reservationID">Reservation ID</label>
    <input type="number" class="form-control" id="reservationID" readonly>
</div>

<div class="form-group col-xs-12 col-md-6">
	<label for="status">Status</label>
    <input type="number" class="form-control" id="status" required>
</div>

<div class="form-group col-xs-12 col-md-6">
	<label for="assetTag">Asset Tag</label>
    <input type="number" class="form-control" id="assetTag" required>
</div>

<div class="form-group col-xs-12 col-md-6">
	<label for="checkOut">Checkout Date & Time</label>
    <input type="text" class="form-control" id="checkOut" readonly >
</div>



<div class="form-group col-xs-12 col-md-6">
    <span>
        <button class="btn btn-primary" type="submit" onclick="submitModifyReservationForm()" data-toggle="tooltip" title="Submit">Submit Change</button>
    </span>
    <span>
        <button class = "btn btn-link" type="button" onclick="window.history.back()" data-toggle="tooltip" title="Cancel">Cancel</button>
    </span>
</div>