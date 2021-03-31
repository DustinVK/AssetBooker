


<div id="calendar"></div>

<div class="form-group col-xs-12 col-md-6">
       <label for="assetTag">Asset Tag</label>
       <input type="text" class="form-control" id="assetTag" value="" readonly>
</div>
<div class="form-group col-xs-12 col-md-6">
       <label for="manufacturer">Manufacturer</label>
       <input type="text" class="form-control" id="manufacturer" value="" readonly>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="model">Model</label>
    <input class="form-control" id="model" required></input>
</div>
<div class="form-group col-xs-12 col-md-6">
	<label for="description">Description</label>
    <input type="text" class="form-control" id="description" readonly>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="checkOutDate">Checkout Date</label>
    <input type="text" class="form-control" id="checkOutDate" required autofocus >
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="checkOutTime">Check-out Time</label>
    <input type="text" class="form-control" id="checkOutTime" autofocus required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="checkInDate">Return Date</label>
    <input type="text" class="form-control" id="checkInDate" required autofocus >
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="checkInTime">Return Time</label>
    <input type="text" class="form-control" id="checkInTime" autofocus required>
</div>

<div class="form-group col-xs-12">
    <span>
        <button class="btn btn-primary" type="submit" onclick=requestReservation(); data-toggle="tooltip" title="Submit">Submit</button>
    </span>
    <span>
        <button class = "btn btn-link" type="button" onclick="window.history.back()" data-toggle="tooltip" title="Cancel">Cancel</button>
    </span>
</div>