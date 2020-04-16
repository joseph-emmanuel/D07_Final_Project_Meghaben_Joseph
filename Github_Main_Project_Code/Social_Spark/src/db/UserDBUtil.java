package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import model.User;

public class UserDBUtil {
	
	
	private DataSource dataSource;

	
	public UserDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
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
}
