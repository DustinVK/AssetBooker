package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class Asset {
	int assetTag, status;
	String manufacturer, model, description, serialNumber;
	Date purchaseDate;
	
	public Asset() {}
	
	public JSONArray displayAssets() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
	
		String sqlString = "SELECT a.assetTag, s.title, a.manufacturer, a.model, a.description " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.assets AS a WITH (NOLOCK) " +
		"LEFT JOIN " + mssqlConnection.getDatabase()+ ".dbo.AssetStatus AS s WITH (NOLOCK) " +
		"ON a.status = s.status " +
		"ORDER BY a.model";			
		
		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	public JSONArray listAssets() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
	
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.assets WITH (NOLOCK) " +
		"ORDER BY assetTag";			
		
		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	public JSONObject getAsset() {

		MSSQLConnection mssqlConnection = new MSSQLConnection();

		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.assets WITH (NOLOCK) " +				
		"WHERE assetTag= "+assetTag+""; 

		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.getQuery();

	}
	
	public String updateAsset() {
		
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

	public String addAsset() {
	
	String message = "Asset Added!";
	
		try {
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String addAsset = "INSERT " + mssqlConnection.getDatabase()+".dbo.assets " +
					"(assetTag, status, manufacturer, model, description, serialNumber, purchaseDate) VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(addAsset);
			
			
			ps.setInt(1, assetTag);
			ps.setInt(2, status);
			ps.setString(3, manufacturer);
			ps.setString(4, model);
			ps.setString(5, description);
			ps.setString(6, serialNumber);
			ps.setDate(7, purchaseDate);
			
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
