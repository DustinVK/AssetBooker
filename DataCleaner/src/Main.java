import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	final static String commaDelimiter = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
	static BufferedReader br;
	
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

		        // Output for testing 

		        System.out.println("tag: " + assetTag);
		        System.out.println("desc: " + description);
		        System.out.println("type: " + type);
		        System.out.println("local: " + location);    
  
	
		       
		 
		 
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
