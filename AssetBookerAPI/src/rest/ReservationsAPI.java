package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import service.AssetService;
import service.ReservationService;
import service.UserService;

@Path("/reservations")
public class ReservationsAPI {

	@GET
	@Produces("application/json")
	@Consumes("application/json")
	public String getAll() {
		JSONArray reservations = ReservationService.getAll();
		
		return reservations.toString();
	}
	
	@GET
	@Path("/active/") 
	@Produces("application/json")
	@Consumes("application/json")
	public String getActive() {
		JSONArray reservations = ReservationService.getActive();
		
		return reservations.toString();
	}
	
	@GET
	@Path("/{tag}/") 
	@Produces("application/json")
	@Consumes("application/json")
	public String get(@PathParam("tag") Integer tag) {
		JSONObject reservation = ReservationService.get(tag);
		
		return reservation.toString();
	}
	
	@GET
	@Path("/status/{id}/") 
	@Produces("application/json")
	@Consumes("application/json")
	public String getByStatus(@PathParam("status") Integer status) {
		JSONArray reservations = ReservationService.getByStatus(status);
		
		return reservations.toString();
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public String add(String inputParms) {

		try {
			JSONObject result = ReservationService.add(new JSONObject(inputParms));
			return result.toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "addReservationAPI failed";

		}
		
	}
	
	
}
