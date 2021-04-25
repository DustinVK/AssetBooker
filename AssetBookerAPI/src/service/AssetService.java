package service;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Asset;
import model.MSSQLConnection;
import model.SQLQuery;
import model.User;

public class AssetService {

	public static JSONArray getAll() {
		JSONArray assets = new JSONArray();
		
		Asset asset = new Asset();
		assets = asset.getAll();
		
		return assets;
		
	}
	
	public static JSONArray getActive() {
		JSONArray assets = new JSONArray();
		
		Asset asset = new Asset();
		assets = asset.getActive();
		
		return assets;
		
	}
	
	public static JSONArray getType(int type) {
		JSONArray assets = new JSONArray();
		
		Asset asset = new Asset();
		asset.setAssetType(type);
		assets = asset.getType();
		
		return assets;
	}
	
	public static JSONObject get(int tag) {
		
		JSONObject assetJO = new JSONObject();
		
		Asset asset= new Asset();
		asset.setAssetTag(tag);
		
		assetJO = asset.get();
		
		return assetJO;
	}
	
}
