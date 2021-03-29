package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class Users {
	int userID;
	String firstName;
	String lastName;
	String email;
	String phoneNumber;
	int status, role;

	public Users() {}
	
	public JSONArray listUsers() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.users WITH (NOLOCK)";			
		
		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	public JSONObject getUser() {

		MSSQLConnection mssqlConnection = new MSSQLConnection();

		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.users WITH (NOLOCK) " +				
		"WHERE userID = "+userID+""; 

		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.getQuery();

	}
	
	public String updateUser() {
		
		String message = "User Updated!";
		
		try {
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String update = "UPDATE " + mssqlConnection.getDatabase()+".dbo.users SET " +
					"firstName=IsNull(NullIf(?,''),firstName), lastName=IsNull(NullIf(?,''),lastName), "+
					"email=IsNull(NullIf(?,''),email), phoneNumber=IsNull(NullIf(?,''),phoneNumber), " +
					"status=IsNull(?,status), role=IsNull(?,role), " +
					"WHERE userID="+userID+"";
			
			PreparedStatement ps = connection.prepareStatement(update);
			

			ps.setString(1,firstName);
			ps.setString(2,lastName);
			ps.setString(3,email);
			ps.setString(4,phoneNumber);
			ps.setInt(6, status);
			
			ps.executeUpdate();
			
			
	    	try { if (ps!= null) ps.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
			
		} catch (Exception e) {
		    System.out.println(e.getMessage());

		}
		
		return message;
	
	}
	
	public String addUser() {
		
		String message = "User Added!";
		
		try {
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String addUser = "INSERT " + mssqlConnection.getDatabase()+".dbo.users " +
			"(userID, firstName, lastName, email, phoneNumber, status, role) VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(addUser);
			
			Date date = new Date();
			
			ps.setInt(1, userID);
			ps.setString(2, firstName);
			ps.setString(3,lastName);
			ps.setString(4,email);
			ps.setString(5, phoneNumber);
			ps.setInt(6, status);
			ps.setInt(7, role);
			ps.setTimestamp(7, new java.sql.Timestamp(date.getTime()));
			
			ps.executeUpdate();
			
			
	    	try { if (ps!= null) ps.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
			
		} catch (Exception e) {
		    System.out.println(e.getMessage());
	
		}
		
		return message;
		
		}
	
	
	// getters and setters 
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
