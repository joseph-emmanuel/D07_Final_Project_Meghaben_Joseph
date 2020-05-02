package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.sql.DataSource;

import model.User;

public class UserDBUtil {
	
	
	private DataSource dataSource;

	
	public UserDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public ArrayList<String> getAllPeople(String email) throws Exception{
		
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ArrayList<String> people = new ArrayList<>();
		try {
			
			conn = this.dataSource.getConnection();
			
			String sql = "SELECT * FROM user WHERE email != ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			res = pstmt.executeQuery();
			
			while(res.next()) {
				String tempFname = res.getString("fname").toString();
				String tempLname = res.getString("lname").toString();				
				people.add(tempFname+" "+tempLname);
				
			}
				
			
		}finally {
			
			close(conn,smt,pstmt,res);
				
		}
			
		
		return people;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public User findUser(String email) throws Exception{
			
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		User foundUser = null;	
		
		try {
			
			conn = this.dataSource.getConnection();
			
			String sql = "SELECT * FROM user WHERE email = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			res = pstmt.executeQuery();
			
			if(res.next()) {
				String tempFname = res.getString("fname").toString();
				String tempLname = res.getString("lname").toString();
				String tempEmail = res.getString("email").toString();
				String tempPass = res.getString("pass").toString();
				
				foundUser = new User(tempFname,tempLname,tempEmail,tempPass);
				
			}
				
			
		}finally {
			
			close(conn,smt,pstmt,res);
				
		}
			
		
		return foundUser;
		
	}
	
	
	
	
	
	private void close(Connection conn, Statement smt, PreparedStatement pstmt, ResultSet res) {
		
		try {
			
			if(conn != null) {
				conn.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(smt != null) {
				smt.close();
			}
			if(res != null) {
				res.close();
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
			
	}
	
	public Boolean sendUser(String fname,String lname,String email,String pass) throws Exception{
		Boolean status=false;	
		int id=getRandom();
		Connection conn = null;
		Statement smt = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		
		User foundUser = null;	
		
		try {
			
			conn = this.dataSource.getConnection();
			
			String sql = String.format("INSERT INTO user (fname,lname,email,pass) VALUES ('%s','%s','%s','%s')", fname,lname,email,pass);
			
			smt = conn.createStatement();
			
			int i = smt.executeUpdate(sql);
	        if (i > 0) {
	            status=true;
	        } 
		}finally {
			
			close(conn,smt,ps,res);
				
		}
		return status;
		
	}
	static int getRandom(){
		int range =10;
		Random rand = new Random(System.currentTimeMillis());
		return rand.nextInt(range);
	}

}
