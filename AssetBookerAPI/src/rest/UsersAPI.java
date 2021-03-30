package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import service.UserService;

@Path("/users")
public class UsersAPI {
	
	@GET
	//@Path("/list/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listUsers() {
		JSONArray articles = UserService.listUsers();
		
		return articles.toString();
	}
	
	@GET
	@Path("/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String getUser(@PathParam("id") Integer id) {
		
		JSONObject user = UserService.getUser(id);
		return user.toString();
		
	}
	
	@GET
	@Path("/listByRole/{id}/") 
	@Produces("application/json")
	@Consumes("application/json")
	public String listUsersByRole(@PathParam("id") Integer id) {
		JSONArray articles = UserService.listUsersByRole(id);
		
		return articles.toString();
	}
	
	@PUT
	//@Path("/update/")
	@Produces("application/json")
	@Consumes("application/json")
	public String updateArticle(String inputParms) {
		try {
			JSONObject result = UserService.updateUser(new JSONObject(inputParms));
			return result.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return("updateUserAPI failed");
		}
		
		
	}
	
	@POST
	//@Path("/add/")
	@Produces("application/json")
	@Consumes("application/json")
	public String addUser(String inputParms) {

		try {
			JSONObject result = UserService.addUser(new JSONObject(inputParms));
			return result.toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "addUserAPI failed";

		}
		
	}

}
