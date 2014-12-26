package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.ParkTransaction;
import bean.User;

public class DBData {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	//static final String DB_URL = "jdbc:mysql://localhost/ParkKoDB";
	static final String DB_URL = "jdbc:mysql://27.254.142.75/ParkKoDB";
	
	//static final String SQL_USER_PK = "SELECT CAR_ID, PROVINCE, NAME, SURNAME, PICTURE FROM ParkKoDB.User WHERE CAR_ID = ? AND PROVINCE = ? AND NAME = ? ";
	static final String SQL_USER_PK = "SELECT CAR_ID, PROVINCE, NAME, SURNAME, PICTURE FROM ParkKoDB.User";
	static final String SQL_PARK_TRANSACTION_PK = "SELECT * FROM ParkKoDB.Park_Transaction";

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
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
			}
			

		} catch (Exception e) {

			e.printStackTrace();
		}


	}
	
	
	
	public User getUser(String carId, String province, String name){
		User memberDB = null;
		
		User memberExpect = new User();
		memberExpect.setCarId(carId);
		memberExpect.setProvince(province);
		memberExpect.setName(name);
		
		try {
			initConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(getSQLUser(carId,  province,  name));
			
			while(rs!=null&&rs.next()&&(!memberExpect.equalsKey(memberDB))){
				memberDB = new User();
				memberDB.setCarId(rs.getString("CAR_ID"));
				memberDB.setProvince(rs.getString("PROVINCE"));
				memberDB.setName(rs.getString("NAME"));
				memberDB.setSurname(rs.getString("SURNAME"));
				memberDB.setPicture(rs.getString("PICTURE"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			close();
		}
		
		if(memberDB.equalsKey(memberExpect)){
			return memberDB;
		}else{
			return new User();
		}
		
	}
	
	public ParkTransaction getParkTransaction(String carId, String province, String name){
		User memberDB = null;
		ParkTransaction transDB = new ParkTransaction();
		
		User memberExpect = new User();
		memberExpect.setCarId(carId);
		memberExpect.setProvince(province);
		memberExpect.setName(name);
		
		
		try {
			initConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(getSQLParkTransaction(carId,  province,  name));
			
			while(rs!=null&&rs.next()&&(!memberExpect.equalsKey(memberDB))){
				memberDB = new User();
				memberDB.setCarId(rs.getString("CAR_ID"));
				memberDB.setProvince(rs.getString("PROVINCE"));
				memberDB.setName(rs.getString("NAME"));
				
				transDB.setCarId(rs.getString("CAR_ID"));
				transDB.setProvince(rs.getString("PROVINCE"));
				transDB.setName(rs.getString("NAME"));
				transDB.setStartTime(rs.getTimestamp("START_TIME"));
				transDB.setEndTime(rs.getTimestamp("END_TIME"));
				
				transDB.setUser(memberDB);
				
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			close();
		}
		
		if(memberDB.equalsKey(memberExpect)){
			return transDB;
		}else{
			return new ParkTransaction();
		}
		
	}
	
	protected String getSQLUser(String carId, String province, String name){
		return SQL_USER_PK;
		
	/*	StringBuilder sql = new StringBuilder("SELECT CAR_ID, PROVINCE, NAME, SURNAME, PICTURE FROM ParkKoDB.User WHERE CAR_ID = '");
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
		return sql.toString();*/
	}
	protected String getSQLParkTransaction(String carId, String province, String name){
		return SQL_PARK_TRANSACTION_PK;
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

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	
}
