package service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.User;

public class UserService {
	
	public static JSONArray listUsers() {
		JSONArray users = new JSONArray();
		
		User user = new User();
		users = user.listUsers();
		
		return users;
		
	}
	
	public static JSONArray listUsersByRole(int role) {
		JSONArray users = new JSONArray();
		
		User user = new User();
		user.setRole(role);
		users = user.listUsersByRole();
		
		return users;
		
	}
	
	public static JSONObject getUser(int id) {
		
		JSONObject userObj = new JSONObject();
		
		User user = new User();
		user.setUserID(id);
		
		userObj = user.getUser();
		
		return userObj;
	}
	
	public static JSONObject updateUser(JSONObject inputParms) {
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
			
		
			message = user.updateUser();
		
			result.put("message", message);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject addUser(JSONObject inputParms) {
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
			
		
			message = user.addUser();
		
			result.put("message", message);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
