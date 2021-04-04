package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
	@Path("/{id}/") 
	@Produces("application/json")
	@Consumes("application/json")
	public String get(@PathParam("id") Integer id) {
		JSONObject reservation = ReservationService.get(id);
		
		return reservation.toString();
	}
	
	@DELETE
	@Path("/{id}/") 
	@Produces("application/json")
	@Consumes("application/json")
	public String delete(@PathParam("id") Integer id) {
		JSONObject reservation = ReservationService.delete(id);
		return reservation.toString();
	}
	
	@GET
	@Path("/status/{id}/") 
	@Produces("application/json")
	@Consumes("application/json")
	public String getByStatus(@PathParam("id") Integer id) {
		JSONArray reservations = ReservationService.getByStatus(id);
		
		return reservations.toString();
	}
	
	@GET
	@Path("/user/{id}/") 
	@Produces("application/json")
	@Consumes("application/json")
	public String getByUser(@PathParam("id") Integer id) {
		JSONArray reservations = ReservationService.getByUser(id);
		
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
	
	@PUT
	@Path("/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String modify(String inputParms) {

		try {
			JSONObject result = ReservationService.update(new JSONObject(inputParms));
			return result.toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "reservation modify api failed";

		}
		
	}
	
	
}
