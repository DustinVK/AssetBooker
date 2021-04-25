package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class Asset implements DataObject {
	int assetTag, status, assetType;
	String manufacturer, model, description, serialNumber;
	Date purchaseDate;
	
	public int getAssetType() {
		return assetType;
	}

	public void setAssetType(int assetType) {
		this.assetType = assetType;
	}

	public Asset() {}
	
	public JSONArray getActive() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
	
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.Assets AS a WITH (NOLOCK) " +
		"LEFT JOIN " + mssqlConnection.getDatabase()+ ".dbo.AssetStatus AS s WITH (NOLOCK) " +
		"ON a.assetStatus = s.assetStatus "+
		"LEFT JOIN " + mssqlConnection.getDatabase()+ ".dbo.AssetTypes AS t WITH (NOLOCK) " +
		"ON a.assetType = t.assetType "+
		"WHERE assetTag > 0 " +
		"ORDER BY a.assetTag " +
		"OFFSET 0 ROWS FETCH NEXT 100 ROWS ONLY";
		
		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	public JSONArray getAll() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
	
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.assets WITH (NOLOCK) " +
		"ORDER BY assetTag";			
		
		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	public JSONArray getType() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
	
//		String sqlString = "SELECT * " +
//		"FROM " + mssqlConnection.getDatabase()+".dbo.assets WITH (NOLOCK) " +
//		"WHERE assetType =" +assetType+" "+
//		"ORDER BY assetTag";	
//		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.assets As a WITH (NOLOCK) " +
		"LEFT JOIN " + mssqlConnection.getDatabase()+ ".dbo.AssetStatus AS s WITH (NOLOCK) " +
		"ON a.assetStatus = s.assetStatus "+
		"LEFT JOIN " + mssqlConnection.getDatabase()+ ".dbo.AssetTypes AS t WITH (NOLOCK) " +
		"ON a.assetType = t.assetType "+
		"WHERE a.assetType= "+assetType+""; 

		
		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	public JSONObject get() {

		MSSQLConnection mssqlConnection = new MSSQLConnection();

		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.assets As a WITH (NOLOCK) " +
		"LEFT JOIN " + mssqlConnection.getDatabase()+ ".dbo.AssetStatus AS s WITH (NOLOCK) " +
		"ON a.assetStatus = s.assetStatus "+
		"LEFT JOIN " + mssqlConnection.getDatabase()+ ".dbo.AssetTypes AS t WITH (NOLOCK) " +
		"ON a.assetType = t.assetType "+
		"WHERE assetTag= "+assetTag+""; 

		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.getQuery();

	}
	
	public String update() {
		
		String message = "Asset Updated!";
		
		try {
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String update = "UPDATE " + mssqlConnection.getDatabase()+".dbo.assets SET " +
					"status=IsNull(?,status), manufacturer=IsNull(NullIf(?,''),manufacturer), model=IsNull(NullIf(?,''),model), "+
					"description=IsNull(NullIf(?,''),description), serialNumber=IsNull(NullIf(?,''),serialNumber),  " +
					"WHERE assetTag="+assetTag+"";
			
			PreparedStatement ps = connection.prepareStatement(update);
			
			ps.setInt(1, status);
			ps.setString(2, manufacturer);
			ps.setString(3, model);
			ps.setString(4, description);
			ps.setString(4, serialNumber);
			ps.executeUpdate();
			
			
	    	try { if (ps!= null) ps.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
			
		} catch (Exception e) {
		    System.out.println(e.getMessage());

		}
		
		return message;

	}

	public String add() {
	
	String message = "Asset Added!";
	
		try {
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String addAsset = "INSERT " + mssqlConnection.getDatabase()+".dbo.assets " +
					"(assetTag, assetStatus, description, assetType, location) VALUES (?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(addAsset);
			
			
			ps.setInt(1, assetTag);
			ps.setInt(2, status);
			ps.setString(3, description);
			ps.setInt(4, assetType);
			ps.setInt(5, 1);
			
			ps.executeUpdate();
			
			
	    	try { if (ps!= null) ps.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
			
		} catch (Exception e) {
		    System.out.println(e.getMessage());
	
		}
		
		return message;
		
	}
	
	
	//getters and setters 
	public int getAssetTag() {
		return assetTag;
	}
	public void setAssetTag(int assetTag) {
		this.assetTag = assetTag;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

}
