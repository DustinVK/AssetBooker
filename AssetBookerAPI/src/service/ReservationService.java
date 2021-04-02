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
	
	public static JSONArray getByStatus(int status) {
		
		JSONArray reservationObj = new JSONArray();
		
		Reservation res = new Reservation();
		res.setStatus(status);
		reservationObj = res.getByStatus();
		
		return reservationObj;
	}

public static JSONObject add(JSONObject inputParms) {
		
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			
			int userID = inputParms.getInt("userID");
			int assetTag = inputParms.getInt("assetTag");
			int status = 1;
			long inDateTime = inputParms.getLong("inDateTime");
			long outDateTime = inputParms.getLong("outDateTime");

			
			String articleTitle = inputParms.getString("articleTitle");
			String articleContent= inputParms.getString("articleContent");
			int articleAuthorID = inputParms.getInt("articleAuthorID");
			int categoryID = inputParms.getInt("categoryID");
			String articleImage = inputParms.getString("articleImage");
			
			//Date date = Date.valueOf(inDateTime);
			
//			Article article = new Article();
//			article.setArticleTitle(articleTitle);
//			article.setArticleContent(articleContent);
//			article.setArticleAuthorID(articleAuthorID);
//			article.setArticleVisible(1);
//			article.setCategoryID(categoryID);
//			article.setArticleImage(articleImage);
//			
//			message = article.addArticle();
//		
//			result.put("message", message);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
