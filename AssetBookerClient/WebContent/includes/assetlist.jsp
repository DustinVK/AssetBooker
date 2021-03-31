


<table class = "table table-hover">
	<thead id="postBody">
		<tr>
			<th>
				<h3>Inventory List</h3>
			</th>
			<th>
				
			</th>
		</tr> 
		<tr>
			<th>
				Description
				<input type="text" id="assetSearch" placeholder="Search descriptions...">
				<button class="btn btn-primary" type="description-search" onclick=requestReservation(); data-toggle="tooltip" title="search descriptions"><i class="fas fa-search"></i></button>
				</th>
			<th>
				<form action="#">
				  <label for="status">Status</label>
				  <select name="status" id="status">
				    <option value="all">All</option>
				    <option value="1">Available</option>
				    <option value="2">Checked Out</option>
				  </select> 
				</form>
				
			</th>
		
				
			<th>
				<form action="#">
				  <label for="type">Type</label>
				  <select name="type" id="type">
				    <option value="all">All</option>
				    <option value="1">Audio</option>
				    <option value="2">Battery</option>
				    <option value="3">Cables</option>
				    <option value="4">Camera</option>
				    <option value="5">Camera Accessory</option>
				    <option value="6">Container</option>
				    <option value="7">Devices</option>
				    <option value="8">Grip</option>
				    <option value="9">Key</option>
				    <option value="10">Keyboard</option>
				    <option value="11">Light Accessories</option>
				    <option value="12">Lights</option>
				    <option value="13">Memory</option>
				    <option value="14">Microphone</option>
				    <option value="15">Monopod</option>
				    <option value="16">Mouse</option>
				    <option value="17">Other</option>
				    <option value="18">Remote Timing Switch</option>
				    <option value="19">Tripod</option>
				  </select> 
				</form>
			</th>
			<th>
				<button class="btn btn-primary" id="asset-filter">Filter</button>
				 <button class="btn btn-primary" id="asset-filter-reset">Reset Fields</button>
			</th>
		</tr>
	</thead>
</table>
