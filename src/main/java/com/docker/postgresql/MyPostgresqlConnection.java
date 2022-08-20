/**
 * 
 */
package com.docker.postgresql;

import java.net.InetAddress;
import java.sql.DriverManager;
import java.util.Map;

/**
 * @author server
 *
 */
public class MyPostgresqlConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String ipAddr = InetAddress.getLocalHost().getHostName();
		System.out.println("Printing IP address of the host " + ipAddr);
		Map<String, String> env = System.getenv();
		for(Map.Entry<String, String> entry:env.entrySet()) {
			System.out.format("%s=%s%n", entry.getKey(), entry.getValue());
		}
		
		
		Thread.sleep(100000);
		
		boolean connected = false;
		
		while(!connected) {
			try {
				// Note the way the postgresql container is used here.
				String url = "jdbc:postgresql://pssqldb:5432/my_database";
				//String url = "jdbc:postgresql://localhost:5432/my_database";
				String user = "postgres";
				String password = "root";
				System.out.println("Connecting to URL " + url);
				// Load the Connector/J driver
				Class.forName("org.postgresql.Driver").newInstance();
				System.out.println("Driver loaded successfully  ");
				// Establish connection to MySQL
				DriverManager.getConnection(url, user, password);
				System.out.println("Connection was successful");
				connected = true;
			}catch (Exception e) {
				System.err.println("Error connecting to database");
				e.printStackTrace();
				Thread.sleep(5000);
			}
			
		}
	}

}
