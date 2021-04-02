package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class User {
	int userID;
	String firstName;
	String lastName;
	String email;
	String phoneNumber;
	int status, role;

	public User() {}
	
	public JSONArray getAll() {
		JSONObject jsonObj = null;
		JSONArray arr = new JSONArray();
		
		try {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		Connection c = mssqlConnection.getConnection();

		Statement stmt = c.createStatement(
				java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_READ_ONLY);
		
		String sqlString = "SELECT * " +
				"FROM " + mssqlConnection.getDatabase()+".dbo.users WITH (NOLOCK)";		
		
		java.sql.ResultSet results = stmt.executeQuery(sqlString);
		
		while(results.next()) {
			
			jsonObj = new JSONObject();
			
			int userID = results.getInt("userID");
			String firstName = results.getString("firstName").trim();
			String lastName = results.getString("firstName").trim();
			String email = results.getString("email").trim();
			String phoneNumber = results.getString("phoneNumber").trim();
			int status = results.getInt("status");
			int role = results.getInt("role");
			
			jsonObj.put("userID", userID);
			jsonObj.put("firstName", firstName);
			jsonObj.put("lastName", lastName);
			jsonObj.put("email", email);
			jsonObj.put("phoneNumber", phoneNumber);
			jsonObj.put("status", status);
			jsonObj.put("role", role);
			
			arr.put(jsonObj);


		}
				
		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		System.out.println(arr);
	    
		//Close Connections
		try { if (results != null) results.close(); } catch (Exception e) {}; 
    	try { if (stmt!= null) stmt.close(); } catch (Exception e) {};
    	try { if (c != null) c.close(); } catch (Exception e) {}; 
	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return arr;
	}
	
	public JSONArray getAllRole() {
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.users WITH (NOLOCK) WHERE role="+role+"";			
		
		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	public JSONObject get() {

		MSSQLConnection mssqlConnection = new MSSQLConnection();

		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase()+".dbo.users WITH (NOLOCK) " +				
		"WHERE userID = "+userID+""; 

		SQLQuery sqlQuery = new SQLQuery(); 
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.getQuery();

	}
	
	public String update() {
		
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
	

	public String add() {
		
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
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	
}
