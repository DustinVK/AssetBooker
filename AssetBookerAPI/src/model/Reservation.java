package model;

import java.util.Date;

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
	
	
}
