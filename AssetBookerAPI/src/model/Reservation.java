package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.sql.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class Reservation implements DataObject {
	int reservationID, userID, assetTag, status;
	Date checkOut;
	Date checkIn;
	Time checkOutTime, checkInTime;
	String checkOutDateTime;
	
	public String getCheckOutDateTime() {
		return checkOutDateTime;
	}

	public void setCheckOutDateTime(String checkOutDateTime) {
		this.checkOutDateTime = checkOutDateTime;
	}

	public JSONArray getAll() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.reservations WITH (NOLOCK) " +
		"ORDER BY reservationID";			
		
		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	public JSONArray getByStatus() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.reservations WITH (NOLOCK) " +
		"WHERE status ="+status+"" +
		"ORDER BY reservationID";			
		
		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	public JSONArray getByUser() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.reservations AS r WITH (NOLOCK) " +
		"LEFT JOIN " + mssqlConnection.getDatabase()+ ".dbo.Assets AS a WITH (NOLOCK) " +
		"ON r.assetTag = a.assetTag "+
		"LEFT JOIN " + mssqlConnection.getDatabase()+ ".dbo.ReservationStatus AS rs WITH (NOLOCK) " +
		"ON r.status = rs.status "+
		"WHERE userID ="+userID+"" +
		"ORDER BY reservationID DESC";			
		
		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	
	public JSONArray getActive() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.reservations WITH (NOLOCK) " +
		"WHERE status > 0 " +
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
		
	public String update() {
			
			String message = "Reservation Updated!";
			
			try {
				MSSQLConnection mssqlConnection = new MSSQLConnection();
				Connection connection = mssqlConnection.getConnection();
				
				String update = "UPDATE " + mssqlConnection.getDatabase()+".dbo.reservations SET " +
						"status=IsNull(?,status), assetTag=IsNull(?,assetTag) WHERE reservationID="+reservationID+"";
				
				PreparedStatement ps = connection.prepareStatement(update);
				
				ps.setInt(1, status);
				ps.setInt(2, assetTag);
				ps.executeUpdate();
				
				
		    	try { if (ps!= null) ps.close(); } catch (Exception e) {};
		    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
				
			} catch (Exception e) {
			    System.out.println(e.getMessage());
	
			}
			
			return message;
	
		}
	
	public JSONObject get() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String sqlString = "SELECT * " +
				"FROM " + mssqlConnection.getDatabase()+".dbo.reservations WITH (NOLOCK) " +
				"WHERE reservationID = " + reservationID + "";
		
		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.getQuery();
	}
	
public String add() {
		
	String message = "Reservation Added!";
	
		try {
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String addAsset = "INSERT " + mssqlConnection.getDatabase()+".dbo.reservations " +
					"(userID, assetTag, status, checkOut) VALUES (?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(addAsset);
			
			
			ps.setInt(1, userID);
			ps.setInt(2, assetTag);
			ps.setInt(3, status);
			ps.setString(4, checkOutDateTime);

			ps.executeUpdate();
			
			
	    	try { if (ps!= null) ps.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
			
		} catch (Exception e) {
		    System.out.println(e.getMessage());
	
		}
		
		return message;
		
	}
	
//	public String delete() {
//		MSSQLConnection mssqlConnection = new MSSQLConnection();
//		Connection connection = mssqlConnection.getConnection();
//
//		
//	
//		
//		SQLQuery sqlQuery = new SQLQuery(); 
//		sqlQuery.setSqlString(sqlString);
//		
//		return sqlQuery.getQuery().toString();
//	}
	
	public String delete() {
		String message = "Reservation Deleted!";
		
		try {
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			String sqlString = "DELETE FROM " +mssqlConnection.getDatabase()+".dbo.reservations " +
					"WHERE reservationID = " + reservationID + "";
			PreparedStatement ps = connection.prepareStatement(sqlString);
			ps.executeUpdate();

			
		} catch (Exception e) {
		    System.out.println(e.getMessage());

		}

		
		return message;
	}
	
	
	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

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

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}


		
	
}
