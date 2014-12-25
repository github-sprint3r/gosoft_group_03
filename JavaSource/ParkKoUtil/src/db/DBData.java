package db;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

public class DBData {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//static final String DB_URL = "jdbc:mysql://localhost/ParkKoDB";
	static final String DB_URL = "jdbc:mysql://27.254.142.75/ParkKoDB";
	
	//static final String SQL_USER_PK = "SELECT CAR_ID, PROVINCE, NAME, SURNAME, PICTURE FROM ParkKoDB.User WHERE CAR_ID = ? AND PROVINCE = ? AND NAME = ? ";
	static final String SQL_USER_PK = "SELECT CAR_ID, PROVINCE, NAME, SURNAME, PICTURE FROM ParkKoDB.User WHERE CAR_ID =?";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	private Connection conn = null;
	private Statement  stmt = null;
	private ResultSet rs = null;

	public DBData() {

	}

	public void initConnection() {

		try {
			if(conn==null || conn.isClosed()){
				//Class.forName("com.mysql.jdbc.Driver");
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
//				conn = DriverManager.getConnection("jdbc:mysql://27.254.142.75/ParkKoDB?" +
//                        "user=root&password=");
			}
			

		} catch (Exception e) {

			e.printStackTrace();
		}

		//return conn;

	}
	
	
	
	public User getUser(String carId, String province, String name){
		User member = new User();
		
		try {
			initConnection();
			stmt = conn.createStatement();
//			stmt.setString(1, carId);
//			stmt.setString(2, province);
//			stmt.setString(3, name);
			//rs = stmt.executeQuery();
			rs = stmt.executeQuery(getSQLUser(carId,  province,  name));
			
			if(rs!=null&&rs.next()){
				member.setCarId(rs.getString("CAR_ID"));
				member.setProvince(rs.getString("PROVINCE"));
				member.setName(rs.getString("NAME"));
				member.setSurname(rs.getString("SURNAME"));
				member.setPicture(rs.getString("PICTURE"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			close();
		}
		
		
		return member;
	}
	
	protected String getSQLUser(String carId, String province, String name){
		StringBuilder sql = new StringBuilder("SELECT CAR_ID, PROVINCE, NAME, SURNAME, PICTURE FROM ParkKoDB.User WHERE CAR_ID = '");
		sql.append(carId);
		//sql.append("'");
		sql.append("' AND PROVINCE = '");
		sql.append(province);
		sql.append("' AND NAME = '");
		sql.append(name);
		sql.append("'");
//		String encode = sql.toString();
//		try {
//			encode = new String(sql.toString().getBytes("UTF-8"),"TIS-620");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		return sql.toString();
	}
	
	protected void close(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}