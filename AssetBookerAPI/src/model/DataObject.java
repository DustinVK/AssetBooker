package model;

import org.json.JSONArray;
import org.json.JSONObject;

public interface DataObject {
	
	public JSONArray getAll();
	public JSONArray getActive();
	public JSONObject get();
	public String update();
	public String add();
	

}
