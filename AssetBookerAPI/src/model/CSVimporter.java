package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * For standarzing the data I was given and importing it into the MSSQL Database
 */

public class CSVimporter {
	final static String commaDelimiter = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
	static BufferedReader br;
	
	public static int getType(String type) {
		int t = -1;
		
		if(type.contentEquals("Audio")) {
			t = 1;
		}
		else if(type.contentEquals("Battery")) {
			t=2;
		}
		else if(type.contentEquals("Cables")) {
			t=3;
		}
		else if(type.contentEquals("Camera")) {
			t=4;
		}
		else if(type.contentEquals("Camera Accessory")) {
			t=5;
		}
		else if(type.contentEquals("Container")) {
			t=6;
		}
		else if(type.contentEquals("Devices")) {
			t=7;
		}
		else if(type.contentEquals("Grip")) {
			t=8;
		}
		else if(type.contentEquals("Key")) {
			t=9;
		}
		else if(type.contentEquals("Keyboard")) {
			t=10;
		}
		else if(type.contentEquals("Light Accessories")) {
			t=11;
		}
		else if(type.contentEquals("Lights")) {
			t=12;
		}
		else if(type.contentEquals("Memory")) {
			t=13;
		}
		else if(type.contentEquals("Microphone")) {
			t=14;
		}
		else if(type.contentEquals("Monopod")) {
			t=15;
		}
		else if(type.contentEquals("Mouse")) {
			t=16;
		}
		else if(type.contentEquals("Other")) {
			t=17;
		}
		else if(type.contentEquals("Remote Timing Switch")) {
			t=18;
		}
		else if(type.contentEquals("Tripod")) {
			t=19;
		}
		
		if(t < 1 ) {
			System.out.println("ERROR getting type:" + type);
		}
		return t;
		
	}
	
	public static void handleData(){
	
		
		try {
			br = new BufferedReader(new FileReader("AssetDatabase.csv"));
					
		    String line;
		    String headerLine = br.readLine(); // this is here to get rid of 1st line with field headers 
		    while ((line = br.readLine()) != null) {
		    	// -1 is used to prevent split() from discarding empty values 
		        String[] values = line.split(commaDelimiter, -1);
		        // make empty values null 
		        for (int i =0; i< values.length;i++) {
		            if(values[i].isEmpty())
		            {
		                values[i] = null;
		            }
		        }
		        
		        String assetTag = values[1];
		        String description = values[2];
		        String type = values[3];
		        String location = values[6];
		        
		        int assetType = getType(type);
		        
		        Asset asset = new Asset();
		        
		        asset.setAssetTag(Integer.valueOf(assetTag));
		        asset.setDescription(description);
		        asset.setAssetType(assetType);
		        asset.setStatus(1);
		        
		        asset.add();
		        

		        // Output for testing 

//		        System.out.println("tag: " + assetTag);
//		        System.out.println("desc: " + description);
//		        System.out.println("type: " + type);
//		        System.out.println("local: " + location);    
  
	
		       
		 
		 
		    }
		    
		}
		catch (FileNotFoundException e) {
	        e.printStackTrace();
		}
		catch (IOException e) {
	        e.printStackTrace();
		}
		finally {
			try {
				if (br != null) {
					br.close();
				}
			}
			catch (IOException closeExcpt) {
				System.out.println("Error closing file: " + closeExcpt.getMessage());
			}
	    }
		
;
	}
	
	


	
	final static String COMMADELIMITER = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

	public static List<List<String>> getList() {
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("AssetDatabase.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(COMMADELIMITER);
		        records.add(Arrays.asList(values));
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return records;
	}

	
	public static void main(String[] args) throws FileNotFoundException {
		handleData();
	}

}
