package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

import org.json.JSONArray;

public class Reservation {
	int reservationID, userID, assetTag, status;
	Date checkOut;
	Date checkIn;
	
	public JSONArray listReservations() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.reservations WITH (NOLOCK) " +
		"ORDER BY reservationID";			
		
		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	public JSONArray listAssetReservations() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.reservations WITH (NOLOCK) " +
		"WHERE assetTag = " + assetTag + "";			
		
		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	public JSONArray listUserReservations() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.reservations WITH (NOLOCK) " +
		"WHERE userID = " + userID + "";			
		
		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
public String updateReservations() {
		
		String message = "Reservation Updated!";
		
		try {
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String update = "UPDATE " + mssqlConnection.getDatabase()+".dbo.reservations SET " +
					"status=IsNull(?,status) WHERE reservationID="+reservationID+"";
			
			PreparedStatement ps = connection.prepareStatement(update);
			
			ps.setInt(1, status);
			ps.executeUpdate();
			
			
	    	try { if (ps!= null) ps.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
			
		} catch (Exception e) {
		    System.out.println(e.getMessage());

		}
		
		return message;

	}

public String addReservation() {
	
String message = "Reservation Added!";

	try {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		Connection connection = mssqlConnection.getConnection();
		
		String addAsset = "INSERT " + mssqlConnection.getDatabase()+".dbo.reservations " +
				"(userID, assetTag, status, checkOut, checkIn) VALUES (?,?,?,?,?)";
		
		PreparedStatement ps = connection.prepareStatement(addAsset);
		
		
		ps.setInt(1, userID);
		ps.setInt(2, assetTag);
		ps.setInt(3, status);
		ps.setDate(4, checkOut);
		ps.setDate(5, checkIn);
		
		ps.executeUpdate();
		
		
    	try { if (ps!= null) ps.close(); } catch (Exception e) {};
    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
		
	} catch (Exception e) {
	    System.out.println(e.getMessage());

	}
	
	return message;
	
}
	
	
}
