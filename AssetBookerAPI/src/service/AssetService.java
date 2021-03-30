package service;

import org.json.JSONArray;

import model.Asset;
import model.User;

public class AssetService {

	public static JSONArray listAssets() {
		JSONArray assets = new JSONArray();
		
		Asset asset = new Asset();
		assets = asset.listAssets();
		
		return assets;
		
	}
	
	public static JSONArray displayAssets() {
		JSONArray assets = new JSONArray();
		
		Asset asset = new Asset();
		assets = asset.displayAssets();
		
		return assets;
		
	}
	
}
