package com.firststep.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class DBConnectionTester {
	Connection connection = null;
	//String driverName = "oracle.jdbc.driver.OracleDriver";
	String driverName = "org.postgresql.Driver";
	//String dburl = "jdbc:oracle:thin:@135.122.6.201:1521:ORCL";
//	String username = "metlife";
//	String password = "metlife2";

//	String dburl = "jdbc:oracle:thin:@135.122.6.207:1521:METLIFEOV";
	String dburl = "jdbc:postgresql://135.122.62.15:5432/VoicePortal";
	String username = "postgres";
	String password = "password1";
	public boolean doConnection(){
		boolean result = false;
		try{
			Class.forName(driverName);
			System.out.println(new Date()+"-going to get the connection");
			connection = DriverManager.getConnection(dburl, username, password);
			System.out.println("connection created"+connection);
		}catch(Exception e){
			System.out.println("connection failed"+e.getMessage());
			e.printStackTrace();
		}
		result = true;
		
		return result;
	}
	public static void main(String args[]){
		System.out.println("db connection tester program started");
		DBConnectionTester dbConnectionTester = new DBConnectionTester();
		System.out.println("going to test it");
		dbConnectionTester.doConnection();
	}
}
