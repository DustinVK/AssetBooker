package service;

import java.sql.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Reservation;

public class ReservationService{

	public static JSONArray getAll() {
		JSONArray reservations = new JSONArray();
		
		Reservation res = new Reservation();
		reservations = res.getAll();
		
		return reservations;
		
	}
	
	public static JSONArray getActive() {
		JSONArray reservations = new JSONArray();
		
		Reservation res = new Reservation();
		reservations = res.getActive();
		
		return reservations;
		
	}
	
	public static JSONObject get(int id) {
		
		JSONObject reservationObj = new JSONObject();
		
		Reservation res = new Reservation();
		res.setReservationID(id);
		reservationObj = res.get();
		
		return reservationObj;
	}
	
	public static JSONObject delete(int id) {
		
		String message = "";
		
		JSONObject result = new JSONObject();
		
		Reservation res = new Reservation();
		res.setReservationID(id);
	
		message = res.delete();
		System.out.print(message);
		
		
		try {
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONArray getByStatus(int status) {
		
		JSONArray reservationObj = new JSONArray();
		
		Reservation res = new Reservation();
		res.setStatus(status);
		reservationObj = res.getByStatus();
		
		return reservationObj;
	}
	
	public static JSONArray getByUser(int user) {
		
		JSONArray reservationObj = new JSONArray();
		
		Reservation res = new Reservation();
		res.setUserID(user);
		reservationObj = res.getByUser();
		
		return reservationObj;
	}

	public static JSONObject add(JSONObject inputParms) {
		
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			
			int userID = inputParms.getInt("userID");
			int assetTag = inputParms.getInt("assetTag");
			int status = 1;
			String checkOutDateTime = inputParms.getString("checkOut");
			
			Reservation res = new Reservation();
			res.setUserID(userID);
			res.setAssetTag(assetTag);
			res.setStatus(status);
			res.setCheckOutDateTime(checkOutDateTime);
			
			message = res.add();
			result.put("message", message);

			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject update(JSONObject inputParms) {
		
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			int reservationID = inputParms.getInt("reservationID");
			int assetTag = inputParms.getInt("assetTag");
			int status = inputParms.getInt("status");
			String checkOutDateTime = inputParms.getString("checkOut");
			
			Reservation res = new Reservation();
			res.setAssetTag(assetTag);
			res.setReservationID(reservationID);
			res.setStatus(status);
			res.setCheckOutDateTime(checkOutDateTime);
			
			message = res.update();
			result.put("message", message);

			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
