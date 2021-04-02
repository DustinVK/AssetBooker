package service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.User;

public class UserService {
	
	public static JSONArray getAll() {
		JSONArray users = new JSONArray();
		
		User user = new User();
		users = user.getAll();
		
		return users;
		
	}
	
	public static JSONArray listUsersByRole(int role) {
		JSONArray users = new JSONArray();
		
		User user = new User();
		user.setRole(role);
		users = user.getAllRole();
		
		return users;
		
	}
	
	public static JSONObject get(int id) {
		
		JSONObject userObj = new JSONObject();
		
		User user = new User();
		user.setUserID(id);
		
		userObj = user.get();
		
		return userObj;
	}
	
	public static JSONObject update(JSONObject inputParms) {
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			//int userID = inputParms.getInt("userID");
			String firstName = inputParms.getString("firstName");
			String lastName = inputParms.getString("lastName");
			String email = inputParms.getString("email");
			String phoneNumber = inputParms.getString("phoneNumber");
			int status = inputParms.getInt("status");
			int role = inputParms.getInt("role");

			
			User user = new User();
		//	user.setUserID(userID);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setPhoneNumber(phoneNumber);
			user.setStatus(status);
			user.setRole(role);
			
		
			message = user.update();
		
			result.put("message", message);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject add(JSONObject inputParms) {
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			String firstName = inputParms.getString("firstName");
			String lastName = inputParms.getString("lastName");
			String email = inputParms.getString("email");
			String phoneNumber = inputParms.getString("phoneNumber");
			int status = inputParms.getInt("status");
			int role = inputParms.getInt("role");

			
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setPhoneNumber(phoneNumber);
			user.setStatus(status);
			user.setRole(role);
			
		
			message = user.add();
		
			result.put("message", message);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
