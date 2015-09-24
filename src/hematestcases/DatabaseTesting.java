package hematestcases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DatabaseTesting {
	
	//Download mysql driver from https://dev.mysql.com/downloads/connector/j/ and add the jar file to 
	//the build path of project
	
	static Connection conn = null;
	private static Statement stmt;
	private static ResultSet results = null;
	public static String DB_URL = "jdbc:mysql://localhost:3306/treehouse_movie_db";
	//Oracle db url = "jdbc:oracle:thin:@localhost:1521/sid"  sid is oracle instace id
	public static String DB_USER = "root";
	public static String DB_PASSWORD = null;
	public static String driver = "com.mysql.jdbc.Driver"; //Oracle "oracle.jdbc.driver.OracleDriver"
	
	@BeforeClass
	public void beforeClass() {
		
		Properties props = new Properties();
		props.setProperty("user", "root");
		props.setProperty("password", "");
		
		try {
			Class.forName(driver).newInstance();
			
			System.out.println("Connecting to database");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			//conn = DriverManager.getConnection(DB_URL, props);
			
			System.out.println("Connected successfully");
			System.out.println("Creating Statement....");
			
			stmt = conn.createStatement();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	@Test
	public void test() throws SQLException {
		String query = "select * from movies";
		try {
			results = stmt.executeQuery(query);
			while(results.next()) {
				int id = results.getInt("id");
				String title = results.getString("title");
				int year = results.getInt("year_released");
				int genreId = results.getInt("genre_id");
				
				System.out.println("ID:" + id);
				System.out.println("Title:" + title);
				System.out.println("Year Released:" + year);
				System.out.println("Genre ID:" + genreId);
				
			}	
			results.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@AfterClass
	public void afterclass() {
		try {
			if (results !=null) 
				results.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
			
		}catch (SQLException se) {
			se.printStackTrace();
		}
		
	}
	
	
}
