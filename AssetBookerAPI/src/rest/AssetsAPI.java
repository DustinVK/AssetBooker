package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.JSONArray;

import service.AssetService;

@Path("/assets")
public class AssetsAPI {
	
	@GET
	//@Path("/list/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listAssets() {
		JSONArray assets = AssetService.displayAssets();
		
		return assets.toString();
	}
	

	
}
