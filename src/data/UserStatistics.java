package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserStatistics {
	public static HashMap<String,String> userStatistics = new HashMap<String,String>();
	
	/**
	 * This method is for saving userStatistics (HashMap<String,String>) by writing its data to the statistics.txt
	*/public static void saveStatistics() {
		 try {
	            BufferedWriter writer = new BufferedWriter(new FileWriter("statistics.txt"));
	            for (Map.Entry<String, String> entry : userStatistics.entrySet()) {
	                String key = entry.getKey();
	                String value = entry.getValue();
	                writer.write(key + "|" + value);
	                writer.newLine();
	            }
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	/**
	 * This method is for updating userStatistics (HashMap<String,String>) by reading relative data from the statistics.txt
	*/public static void startWithStatistics() {
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader("statistics.txt"));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split("\\|");
	                if (parts.length == 2) {
	                    String username = parts[0];
	                    String statistics = parts[1];
	                    userStatistics.put(username, statistics);
	                }
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
